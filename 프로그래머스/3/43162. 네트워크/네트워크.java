import java.util.*;

class Solution {
    static HashSet<Integer>[] net;
    static int[] visited;
    static int count = 1;
    public int solution(int n, int[][] computers) {
        net = new HashSet[n+1];
        visited = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            net[i] = new HashSet<>();
        }
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    net[i+1].add(j+1);
                    net[j+1].add(i+1);
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            dfs(i);
            count++;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            System.out.println(visited[i]);
            set.add(visited[i]);
        }
        
        return set.size();
    }
    
    void dfs(int i) {
        //종료조건
        if(visited[i] != 0) return;
        visited[i] = count;
        
        for(int a : net[i]) {
        dfs(a);
        }
    }
}