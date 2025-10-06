import java.util.*;

class Solution {
    public static int count = 0;
    public static Set<Integer> visitedSet = new HashSet<>();

    public static int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        boolean[] visited = new boolean[N + 1];
        dfs(1, graph, visited, 0, K);

        return visitedSet.size();
    }

    public static void dfs(int node, List<int[]>[] graph, boolean[] visited, int time, int K) {
        if (time > K) return;
        visited[node] = true;
        visitedSet.add(node);

        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            int travelTime = neighbor[1];
            if (!visited[nextNode]) {
                dfs(nextNode, graph, visited, time + travelTime, K);
                visited[nextNode] = false;
            }
        }
    }
}