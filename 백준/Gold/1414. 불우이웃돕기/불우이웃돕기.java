import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * [BOJ] 불우이웃돕기 (1414) / 골드3
 * 최소 신장 트리 문제
 */
public class Main {
    static int[] parent;
    static PriorityQueue<Edge> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        parent = IntStream.rangeClosed(0,N).toArray();
        priorityQueue = new PriorityQueue<>();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmpC = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                int tmp = 0;
                if (tmpC[j] >= 'a' && tmpC[j] <= 'z') tmp = (tmpC[j] - 'a') + 1;
                if (tmpC[j] >= 'A' && tmpC[j] <= 'Z') tmp = (tmpC[j] - 'A') + 27;
                sum += tmp;
                if (i != j && tmp != 0) priorityQueue.offer(new Edge(i, j, tmp));
            }
        }
        int useEdge = 0;
        int result = 0;
        while (!priorityQueue.isEmpty()) {
            Edge now = priorityQueue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        if (useEdge == N - 1) System.out.println(sum - result);
        else System.out.println(-1);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static class Edge implements Comparable<Edge> {
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
