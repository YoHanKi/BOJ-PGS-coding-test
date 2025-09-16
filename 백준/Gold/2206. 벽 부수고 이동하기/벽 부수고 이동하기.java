
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static class Node {
        int x, y, breakable, move;
        public Node(int x, int y, int breakable, int move) {
            this.x = x; this.y = y; this.breakable = breakable; this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2]; // 경우의 수 2개
        deque.add(new Node(0, 0, 1, 0));
        visited[0][0][1] = true; // 시작점 방문 처리
        int answer = -1;

        while (!deque.isEmpty()) {
            Node current = deque.poll();
            if (current.x == N - 1 && current.y == M - 1) {
                answer = current.move + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx <0 || ny < 0 || nx >= N || ny >= M) continue;

                if (arr[nx][ny] == 1 && current.breakable == 1 && !visited[nx][ny][0]) {
                    // 벽을 부술 수 있으며, 방향이 벽이고, 해당 경로로 방문한 적이 없다면
                    visited[nx][ny][0] = true;
                    deque.add(new Node(nx, ny, 0, current.move + 1));
                } else if (arr[nx][ny] == 0 && !visited[nx][ny][current.breakable]) {
                    // 벽이 아니고, 해당 경로로 방문한 적이 없다면
                    visited[nx][ny][current.breakable] = true;
                    deque.add(new Node(nx, ny, current.breakable, current.move + 1));
                }
            }
        }
        System.out.println(answer);
    }
}