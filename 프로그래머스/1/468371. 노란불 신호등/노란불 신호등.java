import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] period = new int[n];
        long limit = 1;
        for (int i = 0; i < n; i++) {
            period[i] = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, period[i]);
        }
        
        long t = 1;
        while (t <= limit) {
            boolean allY = true;
            long jump = 1;
            for (int i = 0; i < n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int P = period[i];
                int now = (int)((t - 1) % P);
                if (now < g || now >= g + y) {
                    allY = false;
                    jump = (now < g) ? (g - now) : (P - now + g);
                    break;
                }
            }
            if (allY) return (int) t;
            t += jump;
        }
        return -1;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}