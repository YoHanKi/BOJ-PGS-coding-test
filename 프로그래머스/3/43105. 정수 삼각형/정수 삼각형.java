class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) dp[n-1][i] = triangle[n-1][i];
        
        for (int i = n-2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}