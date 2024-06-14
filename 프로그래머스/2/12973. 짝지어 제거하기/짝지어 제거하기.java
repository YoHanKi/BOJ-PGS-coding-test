import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int answer = 1;
        
        for(char c : chars) {
            if(!stack.isEmpty()) {
                if(stack.peek() == c) stack.pop();
                else stack.push(c);
            } else stack.push(c);
        }
        if (!stack.isEmpty()) return 0;
        return answer;
    }
}