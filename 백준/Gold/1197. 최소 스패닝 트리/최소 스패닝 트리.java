import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * [BOJ] 최소 스패닝 트리 (1197) / 골드 4
 */
public class Main {
    static int[] parent;
    static PriorityQueue<Edge> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        priorityQueue = new PriorityQueue<>();
        //유니온 파인드 초기화는 인트 스트림이 효율적인 것 같아 적용해 보았다.
        parent = IntStream.rangeClosed(0, N).toArray();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            priorityQueue.offer(new Edge(s,e,v));
        }
        int useEdge = 0;
        int result = 0;
        while (useEdge < N - 1) {
            Edge now = priorityQueue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s , now.e);
                //N-1 까지 구한 엣지를 모두 더한다.
                result += now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        //부모님 재혼 시키기
        if (a != b) parent[b] = a;
    }

    private static int find(int a) {
        //부모님 모셔오기
        if(a == parent[a]) return a;
        //부모님 안오면 찾아가기
        else return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}
