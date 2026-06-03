import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int lastPainted = 0;
        
        for (int s : section) {
            if (s > lastPainted) {
                count++;
                lastPainted = s + m - 1;
            }
        }
        
        return count;
    }
}