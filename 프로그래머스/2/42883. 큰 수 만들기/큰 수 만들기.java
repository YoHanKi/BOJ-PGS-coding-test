import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (k-- > 0) stack.pop();
        
        char[] tmp = new char[stack.size()];
        for(int i = tmp.length - 1; i >= 0; i--) {
            tmp[i] = stack.pop();
        }
        String answer = new String(tmp);
        return answer;
    }
}