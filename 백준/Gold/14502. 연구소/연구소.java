import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static List<int[]> virusPosition;
    private static int max = Integer.MIN_VALUE;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        virusPosition = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virusPosition.add(new int[]{i, j});
                }
            }
        }

        DFS(0);

        System.out.println(max);
    }

    public static void DFS(int depth) {
        if (depth == 3) {
            BFS(arr.length, arr[0].length);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    DFS(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void BFS(int N, int M) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) System.arraycopy(arr[i], 0, copy[i], 0, M);

        Queue<int[]> queue = new LinkedList<>(virusPosition);

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int x = ints[0], y = ints[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }

            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}
