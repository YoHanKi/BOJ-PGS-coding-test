import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //2차원 배열 탐색 배열
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0,0);
        System.out.println(arr[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        //배열 i, j를 받아 1차원배열에 생성
        queue.offer(new int[] {i, j});
        //0, 0 배열은 시작점이므로 true
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            //첫번째, 시작점의 좌표를 now로 받는다.
            int[] now = queue.poll();
            for(int k = 0; k < 4; k++) {
                //4방향 좌표를 확인하여
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //배열 범위 내,
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    //0이 아니면서 방문하지 않은 배열의
                    if(arr[x][y] != 0 && !visited[x][y]) {
                        //방문 여부 true, 2차원 배열의 값을 +1
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                        //다음 배열 확인
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
