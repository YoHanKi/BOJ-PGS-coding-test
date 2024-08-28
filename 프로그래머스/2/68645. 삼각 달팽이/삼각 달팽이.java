import java.util.*;

class Solution {
    int[] dx = {0, 1, -1};
    int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int[][] tower = new int[n][n];
        
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
        
        return Arrays.stream(tower).flatMapToInt(Arrays::stream).filter(t -> t != 0).toArray();
    }
}