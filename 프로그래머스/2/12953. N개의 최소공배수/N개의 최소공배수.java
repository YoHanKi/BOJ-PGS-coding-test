class Solution {
    public int solution(int[] arr) {
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tmp = GCD(gcd, arr[i]);
            gcd = (gcd * arr[i]) / tmp;
        }
        
        return gcd;
    }
    
    public int GCD(int a, int b) {
        if(a % b == 0) return b;
        return GCD(b, a % b);
    }
}