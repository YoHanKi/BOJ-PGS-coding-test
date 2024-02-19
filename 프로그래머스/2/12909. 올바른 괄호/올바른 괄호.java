import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WeeklyQuizFourth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        
        String s = br.readLine();
        char[] strArr = s.toCharArray();

        for(char i : strArr) {
            if(i == '(') {
                stack.push(i);
            } else if(stack.isEmpty()) {
                System.out.println(false);
             return;
            } else stack.pop();
        }
        if (!(stack.size() == 0)) System.out.println(false);
        else System.out.println(true);
    }
}
