import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [BOJ] 최소 비용 구하기 (1916) / 골드5
 */
public class Main {
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list[S].add(new Node(E,V));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //입력받은 start의 최소거리 배열을 0으로 초기화, Node 생성
        queue.offer(new Node(start,0));
        dist[start] = 0;
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int now = nowNode.target;
            //방문하지 않은 배열이라면 실행
            if (!visited[now]) {
                visited[now] = true;
                //연결된 엣지 노드를 탐색
                for (Node n : list[now]) {
                    //연결된 엣지노드가 방문하지 않은 배열이며, (현재까지 온 거리) 보다 타겟의 거리가 더 크다면
                    if (!visited[n.target] && dist[n.target] > dist[now] + n.value) {
                        //타겟을 최소값으로 변환
                        dist[n.target] = dist[now] + n.value;
                        queue.offer(new Node(n.target,dist[n.target]));
                    }
                }
            }
        }
        return dist[end];
    }

    private static class Node implements Comparable<Node> {
        int target, value;
        Node(int target, int value) {
            this.target = target;
            this.value = value;
        }
        //다익스트라는 엣지를 기준으로 최단거리를 측정하기 때문에 우선순위 큐를 사용.
        @Override
        public int compareTo(Node n) {
            return value - n.value;
        }
    }
}
