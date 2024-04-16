import java.util.*;

class Solution {
    static int[][] list;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        list = new int[n + 1][n + 1];
        
        for(int[] result : results) {
            list[result[0]][result[1]] = 1;
            list[result[1]][result[0]] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(list[i][k] == 1 && list[k][j] == 1){
                        list[i][j] = 1;
                        list[j][i] = -1;
                    }
                    if(list[i][k] == -1 && list[k][j] == -1){
                        list[i][j] = -1;
                        list[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int count = 0; 
            for(int j = 1; j <= n; j++){
                if(list[i][j] != 0) count++;
            }
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}