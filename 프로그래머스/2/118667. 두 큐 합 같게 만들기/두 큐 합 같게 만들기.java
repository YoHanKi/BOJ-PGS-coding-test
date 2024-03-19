import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer((long)queue1[i]);
            q2.offer((long)queue2[i]);
        }
        
        if((sum1 + sum2) % 2 != 0) return -1;
        
        int count = 0;
        int times = 0;
        while(sum1 != sum2) {
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(sum1 < sum2) {
                long tmp1 = q2.poll();
                q1.offer(tmp1);
                sum2 -= tmp1;
                sum1 += tmp1;
                count++;
            } else if (sum1 > sum2) {
                long tmp2 = q1.poll();
                q2.offer(tmp2);
                sum1 -= tmp2;
                sum2 += tmp2;
                count++;
            }
            if(queue1.length * 3 < count) return -1; 
        }  
        
        return count;
    }
}