import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int div = s/n;
        s -= div;
        n--;
        answer[0] = div;
        
        if(div <= 0) return new int[]{-1};
        
        int index = 1;
        while(n > 0) {
            div = s / n;
            s -= div;
            n--;
            answer[index++] = div;
        }
        
        return answer;
    }
}