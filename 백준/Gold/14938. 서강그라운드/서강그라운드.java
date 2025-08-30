import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int n,m,r;
    private static int[] itemCount;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemCount = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n+1][n+1];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
            arr[b][a] = c;
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        System.out.println(max);
    }

    public static int dijkstra(int index) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[index] = 0;
        pq.offer(new int[]{index, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];

            if (dist[curNode] < cur[1]) continue;

            for (int i = 1; i <= n; i++) {
                if (arr[curNode][i] == 0) continue;

                int cost = dist[curNode] + arr[curNode][i];
                if (dist[i] > cost && cost <= m) {
                    dist[i] = cost;
                    pq.offer(new int[]{i, dist[i]});
                }
            }
        }

        // 수색 범위 내의 아이템 개수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) { // 수색 범위 내인 경우만
                count += itemCount[i];
            }
        }

        return count;
    }
}
