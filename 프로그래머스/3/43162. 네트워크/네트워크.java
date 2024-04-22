import java.util.*;
import java.util.stream.*;

// class Solution {
//     static HashSet<Integer>[] net;
//     static int[] visited;
//     static int count = 1;
//     public int solution(int n, int[][] computers) {
//         net = new HashSet[n+1];
//         visited = new int[n+1];
        
//         for(int i = 0; i <= n; i++) {
//             net[i] = new HashSet<>();
//         }
        
//         for (int i = 0; i < n; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(computers[i][j] == 1) {
//                     net[i+1].add(j+1);
//                     net[j+1].add(i+1);
//                 }
//             }
//         }
        
//         for(int i = 1; i <= n; i++) {
//             dfs(i);
//             if(visited[i] == count) count++;
//         }
        
//         return Arrays.stream(visited).max().getAsInt();
//     }
    
//     void dfs(int i) {
//         //종료조건
//         if(visited[i] != 0) return;
//         visited[i] = count;
        
//         for(int a : net[i]) {
//         dfs(a);
//         }
//     }
// }

class Solution {
    static HashSet<Integer>[] net;
    static int[] visited;
    public int solution(int n, int[][] computers) {
        net = new HashSet[n+1];
        visited = new int[n+1];
        
        for(int i = 0; i <= n; i++) net[i] = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    net[i+1].add(j+1);
                    net[j+1].add(i+1);
                }
            }
        }
        
        int check = 1;
        for(int i = 1; i <= n; i++) {
            bfs(i, check);
            if(visited[i] == check) check++;
        }
        
        return Arrays.stream(visited).max().getAsInt();
    }
    
    void bfs(int i, int check) {
        Queue<Integer> q = new LinkedList<>();
        for(int j : net[i]) q.offer(j);
        while(!q.isEmpty()) {
            int j = q.poll();
            if(visited[j] == 0) {
                visited[j] = check;
                for(int k : net[j]) q.offer(k);
            }
        }
    }
}