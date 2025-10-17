import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N = 12;
    static int M = 6;

    static char[][] board = new char[N][M];
    static boolean[][] visited;
    static ArrayList<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        //board를 탐색하며 4개 이상 뭉쳐있는 노드를 확인한다.
        while(true) {
            boolean isFinished = true;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if(list.size() >= 4) {
                            isFinished = false; //연쇄가 일어났으므로 더 탐색해보아야 한다.
                            for(int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.'; // 터트려서 없앰
                            }
                        }
                    }
                }
            }
            if(isFinished) break;
            fallPuyos(); // 뿌요들을 떨어뜨린다.
            count++;
        }
        System.out.println(count);
    }

    public static void fallPuyos() {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(char c, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list.add(new Node(x, y));
        q.offer(new Node(x, y));
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && board[nx][ny] == c) {
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}