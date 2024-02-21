import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [BOJ] 최단 경로 (1753) / 골드4
 * 다익스트라 풀이
 */
public class Main {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        //인접리스트 및 최단거리 배열 초기화
        for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
        for (int i = 0; i <= V; i++) distance[i] = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            //단방향이므로
            list[u].add(new Edge(v,w));
        }
        //K번째에서 시작
        q.add(new Edge(K,0));
        //출발 노드의 최단거리 배열 0으로 초기화
        distance[K] = 0;
        while (!q.isEmpty()) {
            Edge now = q.poll();
            int nowV = now.vertex;
            if(visited[nowV]) continue; //방문한적 있다면 큐에 넣지 않음
            visited[nowV] = true;
            for (int i = 0; i < list[nowV].size();i++) {
                Edge tmp = list[nowV].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (distance[next] > distance[nowV] + value) {
                    distance[next] = value + distance[nowV];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }

    private static class Edge implements Comparable<Edge> {
        int vertex, value;
        Edge(int vertex, int value) {
            this.value = value;
            this.vertex = vertex;
        }
        //우선순위 큐를 사용하기 위해 정의(value 기준으로)
        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) return 1;
            else return -1;
        }
    }
}
