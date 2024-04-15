import java.util.*;
import java.time.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
            String[] splits = time.split(":");
            int times = Integer.parseInt(splits[0]) * 60 + Integer.parseInt(splits[1]);
            pq.add(times);
        }
        
        int start = 9 * 60;
        int last = 0;
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pq.isEmpty()) {
                int current = pq.peek();
                if(current <= start && total < m) {
                    pq.poll();
                    total++;
                } else break;
                last = current - 1;
            }
            start += t;
        }
        if(total < m) last = start - t;
        
        String hour = String.format("%02d", last / 60);
        String minute = String.format("%02d", last % 60);
        return hour + ":" + minute;
    }
}