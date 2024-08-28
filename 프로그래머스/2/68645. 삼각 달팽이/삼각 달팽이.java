import java.util.*;

class Solution {
    int[] dx = {0, 1, -1};
    int[] dy = {1, 0, -1};
    int[][] tower;
    
    public int[] solution(int n) {
        tower = new int[n][n];
        
        int x = 0;
        int y = 0;
        int num = 1;
        tower[y][x] = num++;
        while(y + dy[0] < tower.length && tower[y + dy[0]][x] == 0) {
            while(y + dy[0] < tower.length && tower[y + dy[0]][x] == 0) {
                y += dy[0];
                tower[y][x] = num++;
            }
            while(x + dx[1] < tower[0].length && tower[y][x + dx[1]] == 0) {
                x += dx[1];
                tower[y][x] = num++;
            }
            while(y + dy[2] > 0 && x + dx[2] > 0 && tower[y + dy[2]][x + dx[2]] == 0) {
                x += dx[2];
                y += dy[2];
                tower[y][x] = num++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int[] to : tower) {
            for(int t : to) {
                if(t != 0) list.add(t);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}