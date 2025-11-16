import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer = 1;
    static char[][] map;        // 격자판 정보
    static boolean[][] visited; // 십자가 놓인 곳 확인 배열
    static int[] dx = {0, 0, -1, 1};    // 좌우상하에서 x변경값 (col)
    static int[] dy = {-1, 1, 0, 0};    // 좌우상하에서 y변경값 (row)

    // 십자가 정보
    static class Cross {
        int y, x;   // 중심 좌표 (row, col)
        int size;   // 팔 길이 (0이면 한 칸짜리)

        Cross(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
        }

        int area() {
            return 1 + 4 * size;
        }
    }

    static List<Cross> crosses = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 1. 모든 가능한 십자가 목록 만들기
        makeAllCrosses();

        // 2. 두 십자가 조합 전부 검사해서 최대 넓이 곱 찾기
        visited = new boolean[N][M];
        answer = 1; // 최소값 (십자가 두 개의 넓이 곱은 최소 1*1)

        int size = crosses.size();
        for (int i = 0; i < size; i++) {
            Cross a = crosses.get(i);

            // A 십자가를 visited에 표시
            fill(a, true);

            for (int j = i + 1; j < size; j++) {
                Cross b = crosses.get(j);

                // B가 A와 겹치는지 확인
                if (!canPlace(b)) continue;

                int prod = a.area() * b.area();
                if (prod > answer) {
                    answer = prod;
                }
            }

            // A 십자가 표시 해제
            fill(a, false);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    // (1) 모든 가능한 십자가 생성
    static void makeAllCrosses() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] != '#') continue;

                // 이 칸을 중심으로 할 수 있는 최대 팔 길이 계산
                int maxSize = getMaxSize(y, x);

                // 크기 0 ~ maxSize 까지 모두 십자가로 추가
                for (int s = 0; s <= maxSize; s++) {
                    crosses.add(new Cross(y, x, s));
                }
            }
        }
    }

    // (1-1) (y,x)를 중심으로 가능한 최대 팔 길이
    static int getMaxSize(int y, int x) {
        int len = 0;

        while (true) {
            int next = len + 1;
            boolean ok = true;

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir] * next;
                int nx = x + dx[dir] * next;
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    ok = false;
                    break;
                }
                if (map[ny][nx] != '#') {
                    ok = false;
                    break;
                }
            }

            if (!ok) break;
            len++;
        }

        return len;
    }

    // (2) 십자가를 visited에 채우거나 지우기
    static void fill(Cross c, boolean val) {
        visited[c.y][c.x] = val;
        for (int dist = 1; dist <= c.size; dist++) {
            for (int dir = 0; dir < 4; dir++) {
                int ny = c.y + dy[dir] * dist;
                int nx = c.x + dx[dir] * dist;
                visited[ny][nx] = val;
            }
        }
    }

    // (3) 현재 visited 상태에서 이 십자가를 놓을 수 있는지 (겹침 여부 검사)
    static boolean canPlace(Cross c) {
        // 중심
        if (visited[c.y][c.x]) return false;

        // 팔
        for (int dist = 1; dist <= c.size; dist++) {
            for (int dir = 0; dir < 4; dir++) {
                int ny = c.y + dy[dir] * dist;
                int nx = c.x + dx[dir] * dist;
                if (visited[ny][nx]) return false;
            }
        }
        return true;
    }
}
