class Solution {
    public static int solution(int[] stones, int k) {
        int start = 1;
        int end = 200_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (canCross(stones, k, mid)) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    public static boolean canCross(int[] stones, int k, int people) {
        int consecutiveZeros = 0;
        for (int stone : stones) {
            if (stone - people < 0) {
                consecutiveZeros++;
                if (consecutiveZeros >= k) return false;
            } else consecutiveZeros = 0;
        }
        return true;
    }
}