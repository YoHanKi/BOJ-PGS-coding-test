import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> in = new LinkedList<>();
        int[] times = new int[truck_weights.length]; 
        int time = 0, index = 0, wSum = 0;

        while(index < truck_weights.length || !in.isEmpty()) {
            time++;
            
            if (!in.isEmpty() && times[in.peek()] == time)
                wSum -= truck_weights[in.poll()];
            
            if (index < truck_weights.length && wSum + truck_weights[index] <= weight) {
                in.offer(index);
                wSum += truck_weights[index];
                times[index] = time + bridge_length;
                index++;
            }
        }

        return time;
    }
}