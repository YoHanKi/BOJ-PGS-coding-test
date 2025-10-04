import java.util.*;

class Solution {
    public static int solution(int n, int[][] wires) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int minDiff = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].remove((Integer) b);
            graph[b].remove((Integer) a);

            int countA = dfs(a, graph, visited);
            int countB = n - countA;
            int diff = Math.abs(countA - countB);
            minDiff = Math.min(minDiff, diff);

            visited = new boolean[n + 1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return minDiff;
    }

    public static int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }
        return count;
    }
}