import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < 4; i++) {
            dp[land.length-1][i] = land[land.length-1][i];
        }
        
        //바텀 업 방식으로 아래행부터 시작
        for(int i = land.length - 2; i >= 0; i--) {
            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    //같은 열은 제외
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][k] + land[i][j]);
                }
            }
        }
        
        return Arrays.stream(dp[0]).max().getAsInt();
    }
}