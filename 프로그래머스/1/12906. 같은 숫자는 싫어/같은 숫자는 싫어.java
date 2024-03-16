import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> q = new ArrayDeque<>();
        
        q.offer(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(q.peekLast() == arr[i]) continue;
            else q.offer(arr[i]);
        }
        
        int[] answer = new int[q.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        
        return answer;
    }
}