class Solution {
    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0원을 만드는 방법은 1가지
        for (int coin : money) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }
        return dp[n];
    }
}