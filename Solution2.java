package beginner;
 
//짝수는 싫어요
class Solution2 {
    public int[] solution(int n) {
        int[] answer;
        int k = 0;
        
        if(n % 2 == 0) {
            answer = new int[n/2];
        } else answer = new int[n/2+1];
        
        for(int i=1; i <= n; i++) {
            if(i%2 == 1) {
                answer[k] = i;
                    k++;
            }
        }
        return answer;
    }
}
/* 스트림을 이용한 홀수 선별법
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}
*/