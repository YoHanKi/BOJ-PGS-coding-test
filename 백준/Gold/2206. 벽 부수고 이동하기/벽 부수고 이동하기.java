import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, breakable;
        public Node(int x, int y, int breakable) {
            this.x = x; this.y = y; this.breakable = breakable;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];

        deque.add(new Node(0, 0, 1));
        visited[0][0][1] = true;
        int move = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int s = 0; s < size; s++) {
                Node current = deque.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                    if (nx == N - 1 && ny == M - 1) {
                        System.out.println(move + 1);
                        return;
                    }

                    if (arr[nx][ny] == 0 && !visited[nx][ny][current.breakable]) {
                        visited[nx][ny][current.breakable] = true;
                        deque.add(new Node(nx, ny, current.breakable));
                    } else if (arr[nx][ny] == 1 && current.breakable == 1 && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        deque.add(new Node(nx, ny, 0));
                    }
                }
            }
            move++;
        }
        System.out.println(-1);
    }
}
