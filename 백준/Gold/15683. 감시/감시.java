import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
        static int EMPTY = 0, WALL = 6;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int MIN = Integer.MAX_VALUE;
    static List<int[]> cctvs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != EMPTY && office[i][j] != WALL) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }

        DFS(office, 0);

        System.out.println(MIN);
    }

    public static void DFS(int[][] office, int index) {
        if (index == cctvs.size()) {
            int count = 0;
            for (int[] ints : office) {
                for (int num : ints) if (num == EMPTY) count++;
            }
            MIN = Math.min(MIN, count);
            return;
        }

        int[] cur = cctvs.get(index);
        int x = cur[0];
        int y = cur[1];
        int currentCCTV = office[x][y];
        if (currentCCTV == 1) {
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i, index, false);
                DFS(office, index + 1);
                watch(office, x, y, i, index, true);
            }
        } else if (currentCCTV == 2) {
            for (int i = 0; i < 2; i++) {
                watch(office, x, y, i, index, false);
                watch(office, x, y, i + 2, index, false);
                DFS(office, index + 1);
                watch(office, x, y, i, index, true);
                watch(office, x, y, i + 2, index, true);
            }
        } else if (currentCCTV == 3) {
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i, index, false);
                watch(office, x, y, (i + 1) % 4, index, false);
                DFS(office, index + 1);
                watch(office, x, y, i, index, true);
                watch(office, x, y, (i + 1) % 4, index, true);
            }
        } else if (currentCCTV == 4) {
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i, index, false);
                watch(office, x, y, (i + 1) % 4, index, false);
                watch(office, x, y, (i + 2) % 4, index, false);
                DFS(office, index + 1);
                watch(office, x, y, i, index, true);
                watch(office, x, y, (i + 1) % 4, index, true);
                watch(office, x, y, (i + 2) % 4, index, true);
            }
        } else if (currentCCTV == 5) {
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i, index, false);
            }
            DFS(office, index + 1);
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i, index, true);
            }
        }
    }

    public static void watch(int[][] office, int x, int y, int direction, int index, boolean undo) {
        int N = office.length;
        int M = office[0].length;
        int nx = x;
        int ny = y;
        index += 10;
        while (true) {
            nx += dx[direction];
            ny += dy[direction];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || office[nx][ny] == WALL) break;
            if (undo && office[nx][ny] >= 10) {
                office[nx][ny] -= index;
            } else if (office[nx][ny] == EMPTY || office[nx][ny] >= 10) {
                office[nx][ny] += index;
            }
        }
    }
}