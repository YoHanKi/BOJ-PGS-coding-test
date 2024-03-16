import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : progresses) q.offer(i);
        
        int day = 1;
        int index = 0;
        int count = 0;
        while(!q.isEmpty()) {
            if(q.peek() + (speeds[index] * day) < 100) {
                day++;
                continue;
            } else {
                while(!q.isEmpty()) {
                    if(q.peek() + (speeds[index] * day) >= 100) {
                        q.poll();
                        index++;
                        count++;
                    } else break;
                }
                list.add(count);
                count = 0;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}