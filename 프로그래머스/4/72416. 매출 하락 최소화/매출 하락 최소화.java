import java.util.*;

public class Solution {
    public int solution(int[] sales, int[][] links) {
        int answer = -1;

        int n = sales.length;

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] link : links) {
            int parent = link[0] - 1;
            int child = link[1] - 1;
            tree[parent].add(child);
        }

        int[][] dp = new int[n][2]; // dp[i][0]: 본인이 회의에 참석하지 않는 경우, dp[i][1]: 본인이 회의에 참석하는 경우
        boolean[] visited = new boolean[n];
        DFS(0, tree, sales, dp, visited);

        answer = Math.min(dp[0][0], dp[0][1]);
        return answer;
    }

    private void DFS(int node, List<Integer>[] tree, int[] sales, int[][] dp, boolean[] visited) {
        visited[node] = true;

        for (int child : tree[node]) {
            if (!visited[child]) {
                DFS(child, tree, sales, dp, visited);
            }
        }

        dp[node][0] = 0;
        dp[node][1] = sales[node];

        int minDiff = Integer.MAX_VALUE;
        boolean hasChild = false;

        for (int child : tree[node]) {
            hasChild = true;
            dp[node][0] += Math.min(dp[child][0], dp[child][1]);
            dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            minDiff = Math.min(minDiff, dp[child][1] - dp[child][0]);
        }

        if (hasChild && minDiff > 0) {
            dp[node][0] += minDiff;
        }
    }
}