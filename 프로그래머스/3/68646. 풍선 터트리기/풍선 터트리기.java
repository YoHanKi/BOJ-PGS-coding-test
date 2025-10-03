class Solution {
    public static int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        int count = 2;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                count++;
            }
        }

        return count;
    }
}