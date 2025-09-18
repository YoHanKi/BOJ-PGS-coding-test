
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cell = Integer.parseInt(st.nextToken());
                map[i][j] = cell;
            }
        }

        int time = 0;
        while (true) {
            time++;
            boolean[][] visited = new boolean[N][M];
            dfs(0, 0, map, visited);

            int[][] toBeMelted = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int count = 0;
                        if (i > 0 && visited[i - 1][j]) count++;
                        if (i < N - 1 && visited[i + 1][j]) count++;
                        if (j > 0 && visited[i][j - 1]) count++;
                        if (j < M - 1 && visited[i][j + 1]) count++;
                        toBeMelted[i][j] = count;
                    }
                }
            }

            boolean anyMelted = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (toBeMelted[i][j] >= 2) {
                        map[i][j] = 0;
                        anyMelted = true;
                    }
                }
            }

            if (!anyMelted) break;
        }

        System.out.println(time - 1);

    }

    private static void dfs(int x, int y, int[][] map, boolean[][] visited) {
        int N = map.length;
        int M = map[0].length;
        if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y] == 1) {
            return;
        }
        visited[x][y] = true;
        dfs(x - 1, y, map, visited);
        dfs(x + 1, y, map, visited);
        dfs(x, y - 1, map, visited);
        dfs(x, y + 1, map, visited);
    }
}