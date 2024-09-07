import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if(c == '(') stack.push('(');
                else if(c == '[') stack.push('[');
                else if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                } else if(c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
