class Solution {
    public static int LIMIT;

    public static int solution(int[] diffs, int[] times, long limit) {
        for (int diff : diffs) LIMIT = Math.max(LIMIT, diff);
        
        int n = diffs.length;
        int left = 1, right = LIMIT;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(diffs, times, n, mid, limit)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isPossible(int[] diffs, int[] times, int n, int level, long limit) {
        long total = times[0];
        for (int i = 1; i < n; i++) {
            if (total > limit) return false;
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long sumNum = times[i] + times[i - 1];
                int diff = diffs[i] - level;
                int time = times[i];
                total += sumNum * diff + time;
            }
        }
        return total <= limit;
    }
}