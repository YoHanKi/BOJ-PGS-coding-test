import java.util.*;

class Solution {
    private Queue<String> queue = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        final int MISS = 5;
        final int HIT = 1;
        int answer = 0;
        
        for(String city : cities) {
            String ignoreCase = city.toLowerCase();
            
            if(queue.contains(ignoreCase)) {
                answer += HIT;
                queue.remove(ignoreCase);
                queue.add(ignoreCase);
            } else {
                answer += MISS;
                if(queue.size() >= cacheSize) queue.poll();
                if(queue.size() < cacheSize) queue.add(ignoreCase);
            }
            
        }
        return answer;
    }
}