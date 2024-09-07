import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String commend = br.readLine();
            if(goodWord(commend)) count++;
        }
        System.out.println(count);
    }
    private static boolean goodWord(String commend) {
        Stack<Character> stack = new Stack<>();
        stack.push(commend.charAt(0));
        for (int i = 1; i < commend.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == commend.charAt(i)) {
                stack.pop();
            } else stack.push(commend.charAt(i));
        }
        return stack.isEmpty();
    }
}