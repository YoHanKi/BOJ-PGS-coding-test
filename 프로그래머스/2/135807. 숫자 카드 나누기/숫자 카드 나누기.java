class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (isValid(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        if (isValid(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean isValid(int gcdA, int[] arrayB) {
        for (int b : arrayB) {
            if (b % gcdA == 0) return false;
        }
        return true;
    }
}