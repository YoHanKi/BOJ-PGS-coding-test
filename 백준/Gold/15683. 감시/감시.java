import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int UNEMPTY = -1, EMPTY = 0, WALL = 6;
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
                int[][] copy = copyOf(office);
                watch(office, x, y, i);
                DFS(office, index + 1);
                office = copy;
            }
        } else if (currentCCTV == 2) {
            for (int i = 0; i < 2; i++) {
                int[][] copy = copyOf(office);
                watch(office, x, y, i);
                watch(office, x, y, i + 2);
                DFS(office, index + 1);
                office = copy;
            }
        } else if (currentCCTV == 3) {
            for (int i = 0; i < 4; i++) {
                int[][] copy = copyOf(office);
                watch(office, x, y, i);
                watch(office, x, y, (i + 1) % 4);
                DFS(office, index + 1);
                office = copy;
            }
        } else if (currentCCTV == 4) {
            for (int i = 0; i < 4; i++) {
                int[][] copy = copyOf(office);
                watch(office, x, y, i);
                watch(office, x, y, (i + 1) % 4);
                watch(office, x, y, (i + 2) % 4);
                DFS(office, index + 1);
                office = copy;
            }
        } else if (currentCCTV == 5) {
            int[][] copy = copyOf(office);
            for (int i = 0; i < 4; i++) {
                watch(office, x, y, i);
            }
            DFS(office, index + 1);
            office = copy;
        }
    }

    public static void watch(int[][] office, int x, int y, int direction) {
        int N = office.length;
        int M = office[0].length;
        int nx = x;
        int ny = y;
        while (true) {
            nx += dx[direction];
            ny += dy[direction];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || office[nx][ny] == WALL) break;
            if (office[nx][ny] == (EMPTY)) {
                office[nx][ny] = UNEMPTY;
            }
        }
    }

    public static int[][] copyOf(int[][] office) {
        int N = office.length;
        int M = office[0].length;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = office[i][j];
            }
        }
        return copy;
    }
}