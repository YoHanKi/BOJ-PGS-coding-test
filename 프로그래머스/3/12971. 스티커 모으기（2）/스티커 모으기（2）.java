class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        
        // 스티커가 한 장만 있는 경우
        if (n == 1) return sticker[0];
        
        // 첫 번째 스티커를 포함하는 경우와 포함하지 않는 경우
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // 첫 번째 스티커를 포함하는 경우
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }
        
        // 첫 번째 스티커를 포함하지 않는 경우
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        
        // 두 경우 중 최댓값 반환
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}