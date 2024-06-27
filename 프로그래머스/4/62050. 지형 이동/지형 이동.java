import java.util.*;

class Solution {
    private class Node {
        int i, j, cost;
        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    
    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    boolean[][] visited;
    int answer;
    
    public int solution(int[][] land, int height) {
        visited = new boolean[land.length][land.length];
        answer = 0;
        
        DFS(new Node(0,0,0), land, height);
        
        return answer;
    }
    
    void DFS(Node node, int[][] land, int height) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(node);
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (visited[now.i][now.j]) continue;
            visited[now.i][now.j] = true;
            
            answer += now.cost;
            
            for(int i = 0; i < 4; i++) {
                int ni = now.i + dx[i];
                int nj = now.j + dy[i];
                
                if (ni < 0 || ni >= land.length || nj < 0 || nj >= land.length) continue;
                
                int temp = Math.abs(land[now.i][now.j] - land[ni][nj]);
                int newCost = temp > height ? temp : 0;
                
                pq.offer(new Node(ni, nj, newCost));
            }
        }
    }
}