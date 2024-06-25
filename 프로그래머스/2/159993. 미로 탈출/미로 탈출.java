import java.util.*;

class Solution {
    
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    char[][] map;
    
    private class Point {
        int nx, ny;
        public Point(int nx, int ny) {
            this.nx = nx;
            this.ny = ny;
        }
    }
    
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        
        Point start = null, end = null, lever = null;
        
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                if(map[i][j] == 'S') start = new Point(j, i);
                else if(map[i][j] == 'L') lever = new Point(j, i);
                else if(map[i][j] == 'E') end = new Point(j, i);
            }
        }
        
        int startToLever = bfs(start, lever);
        int leverToEnd = bfs(lever, end);
        
        if(startToLever == -1 || leverToEnd == -1) return -1;
        else return startToLever + leverToEnd;
    }
    
    private int bfs(Point start, Point end) {
        int[][] dist = new int[map.length][map[0].length];
        Queue<Point> q = new LinkedList<>();
        dist[start.ny][start.nx] = 1;
        q.add(start);
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];
                
                if (nextX < 0 || nextX >= map[0].length || nextY < 0 || nextY >= map.length) continue;
                if (dist[nextY][nextX] > 0) continue;
                if (map[nextY][nextX] == 'X') continue;
                
                dist[nextY][nextX] = dist[now.ny][now.nx] + 1;
                
                q.add(new Point(nextX, nextY));
                
                if (nextX == end.nx && nextY == end.ny) return dist[end.ny][end.nx] -1;
            }
        }
        
        return -1;
    }
}