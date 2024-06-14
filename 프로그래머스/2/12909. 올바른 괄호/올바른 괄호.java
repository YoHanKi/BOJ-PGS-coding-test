import java.util.Stack;

class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        if(chars[0] == ')') return false;
        Stack<Character> stack = new Stack<>();
        
        for(char c : chars) {
            if (c == '(') stack.push(c);
            else {
                if(stack.isEmpty() || stack.pop() == c)
                    return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}