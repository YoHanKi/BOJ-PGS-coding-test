
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int BABY_SHARK = 9;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[] cur = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cell = Integer.parseInt(st.nextToken());
                map[i][j] = cell;
                if (cell == BABY_SHARK) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0; 
        int move = 0; 

        while (true) {
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];

            que.add(new int[]{cur[0], cur[1], 0}); 
            visit[cur[0]][cur[1]] = true;

            boolean ck = false; 

            while (!que.isEmpty()) {
                cur = que.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) { 
                    map[cur[0]][cur[1]] = 0; 
                    eat++;
                    move += cur[2]; 
                    ck = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || visit[ny][nx] || map[ny][nx] > size)
                        continue;

                    que.add(new int[]{ny, nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }

            if (!ck) 
                break;

            if (size == eat) { 
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}
