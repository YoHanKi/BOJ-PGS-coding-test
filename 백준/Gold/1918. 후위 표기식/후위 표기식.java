
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    sb.append(c);
                } else {
                    if (c == '(') {
                        stack.push(c);
                    } else if (c == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    } else {
                        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }
}
