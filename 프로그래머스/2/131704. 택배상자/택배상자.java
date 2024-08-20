import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int count = 1;
        for(int i = 0; i < order.length; i++) {
            // 상자가 나오는 순서와 트럭에 실어야 할 순서가 맞으면 스택+
            while(count <= order[i]) {
                stack.push(count++); 
            }
            
            // 스택의 상단이 현재 트럭에 실어야 할 순서와 맞으면 answer++;
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop(); 
                answer++;
            } else break;
        }
        
        return answer;
    }
}