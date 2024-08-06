import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        for(int i = 0; i < answer.length; i++) {
            long cal1 = (left/n) + 1;
            long cal2 = (left+1) % n;
            answer[i] = (int)Math.max(cal1, cal2 == 0 ? n : cal2);
            left++;
        }
        return answer;
    }
}