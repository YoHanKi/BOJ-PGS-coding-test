import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        int sum_truck_weight = 0;
        int time = 0;
        
        for(int truck_weight : truck_weights){
            while(true){
                if(q.size() == bridge_length){
                    sum_truck_weight -= q.remove();
                }
                else if(sum_truck_weight + truck_weight <= weight){
                    sum_truck_weight += truck_weight;
                    q.add(truck_weight);
                    time++;
                    break;
                }
                else {
                    q.add(0);
                    time++;
                }
            }
        }
        return time + bridge_length;
    }
}