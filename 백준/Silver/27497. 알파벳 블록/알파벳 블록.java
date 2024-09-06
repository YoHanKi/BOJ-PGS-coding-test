import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Boolean> remember = new Stack<>();
        Deque<String> printDeque = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            String commend = br.readLine();

            commendSwitch(commend, remember, printDeque);
        }

        if (printDeque.isEmpty()) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            for(String str : printDeque) {
                sb.append(str);
            }
            System.out.println(sb);
        }
    }

    public static void commendSwitch(String commend, Stack<Boolean> remember, Deque<String> printDeque) {
        String[] order = commend.split(" ");
        switch (Integer.parseInt(order[0])) {
            case 1 : printDeque.add(order[1]);
            remember.push(true);
            break;
            case 2 : printDeque.addFirst(order[1]);
            remember.push(false);
            break;
            case 3 : if (!printDeque.isEmpty()) removeDeque(remember.pop(), printDeque);
            break;
        }
    }

    public static void removeDeque(boolean remember, Deque<String> printDeque) {
        if (remember) {
            printDeque.removeLast();
        } else {
            printDeque.removeFirst();
        }
    }
}
