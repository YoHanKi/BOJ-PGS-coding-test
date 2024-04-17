import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for(int work : works) {
            pq.add(work);
        }
        
        while(!pq.isEmpty() && n != 0) {
            int num = pq.poll();
            if(num - 1 != 0) pq.add(num - 1);
            n--;
        }
        
        if (pq.isEmpty()) return 0L;
        else {
            while(!pq.isEmpty()) {
                answer = answer + (long) Math.pow(pq.poll(), 2);
            }
        }
        
        return answer;
    }
}