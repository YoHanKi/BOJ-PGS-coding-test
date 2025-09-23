import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int start;
    static int max;
    static ArrayList<int[]>[] tree;

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());

            tree = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                while (true) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == -1) break;
                    int cost = Integer.parseInt(st.nextToken());
                    tree[node].add(new int[]{v, cost});
                }
            }

            boolean[] visited = new boolean[V + 1];
            DFS(0, 1, visited);

            visited = new boolean[V + 1];
            DFS(0, start, visited);

            System.out.println(max);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DFS(int cost, int node, boolean[] visited) {
        if (cost > max) {
            max = cost;
            start = node;
        }
        visited[node] = true;

        for (int[] next : tree[node]) {
            if (!visited[next[0]]) {
                DFS(cost + next[1], next[0], visited);
            }
        }
    }
}