import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        char[] strArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char i : strArr) {
            if(i == '(') {
                stack.push(i);
            } else if(stack.isEmpty()) {
                return answer;
            } else stack.pop();
            
        }
        
        if (!(stack.size() == 0)) return answer;
        return answer = true;
    }
}