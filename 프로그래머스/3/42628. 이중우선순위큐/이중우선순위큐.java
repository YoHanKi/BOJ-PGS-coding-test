import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> pqOrder = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (String operation : operations) {
            String[] tmp = operation.split(" ");
            if (tmp[0].equals("I")) {
                int num = Integer.parseInt(tmp[1]);
                pqOrder.add(num);
            } else {
                if(pqOrder.isEmpty()) continue;
                if(tmp[1].equals("-1")) {
                    pqOrder.remove();
                } else {
                    while(!pqOrder.isEmpty()) {
                        pqReverse.add(pqOrder.remove());
                    }
                    pqReverse.remove();
                    while(!pqReverse.isEmpty()) {
                        pqOrder.add(pqReverse.remove());
                    }
                }
            }
        }
        
        if(!pqOrder.isEmpty()) {
            int count = pqOrder.size();
            answer[1] = pqOrder.peek();
            while(!pqOrder.isEmpty()) {
                count--;
                int tmp = pqOrder.poll();
                if(count == 0) answer[0] = tmp;
            }
        }
        
        return answer;
    }
}