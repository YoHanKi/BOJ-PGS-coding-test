import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i : scoville) {
            pq.add((long)i);
        }
        
        int count = 0;
        
        while(!pq.isEmpty()) {
            if(pq.peek() >= K || pq.size() < 2) break;
            long first = pq.poll();
            long second = pq.poll();
            
            long mix = first + (second * 2);
            pq.add(mix);
            answer++;
            count++;
        }
        if((pq.peek() < K && pq.size() < 2) || count >= scoville.length) answer = -1;
        
        return answer;
    }
}