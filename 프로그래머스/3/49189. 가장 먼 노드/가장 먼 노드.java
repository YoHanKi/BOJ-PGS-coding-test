import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        count = new int[n+1];
        int answer = 0;
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : edge) {
            list[i[0]].add(i[1]);
            list[i[1]].add(i[0]);
        }
        count[1] = 1;
        BFS(1);
        
        int max = 0;
        for(int i : count) max = Math.max(i, max);
        
        for(int i : count) {
            if (max == i) answer++;
        }
        return answer;
    }
    
    public void BFS(int a){
        Queue<Integer> q = new LinkedList<>();
        visited[a] = true;
        q.offer(a);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i : list[now]) {
                if(!visited[i]) {
                visited[i] = true;
                q.offer(i);
                count[i] += count[now] + 1;
                }
            }
        }
    }
}