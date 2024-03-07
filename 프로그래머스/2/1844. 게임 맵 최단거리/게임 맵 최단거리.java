import java.util.*;

class Solution {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        int answer = 0;
        
        maps[n-1][m-1] = -1;
        BFS(0, 0, maps);

        return answer = maps[n - 1][m - 1];
    }
    
    
    public void BFS(int i, int j, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        int[] start = {i, j};
        queue.offer(start);
        int count;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            count = maps[x][y];
            for (int d = 0; d < 4; d++) {
                int tmpX = x + dx[d];
                int tmpY = y + dy[d];
                if (tmpX >= 0 && tmpX < maps.length && tmpY >= 0 && tmpY < maps[0].length) {
                    if (!visited[tmpX][tmpY] && maps[tmpX][tmpY] != 0) {
                        visited[tmpX][tmpY] = true;
                        maps[tmpX][tmpY] = count + 1;
                        int[] tmp = {tmpX, tmpY};
                        queue.offer(tmp);
                    }
                }
            }
        }
    }
}