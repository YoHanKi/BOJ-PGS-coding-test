import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<String> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String commend = br.readLine();
            printDeque(commend);
        }
    }

    private static void printDeque(String commend) {
        String[] order = commend.split(" ");

        switch (order[0].charAt(0)) {
            case 's' :
                System.out.println(deque.size());
                break;
            case 'e' :
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;
            case 'f' :
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
                break;
            case 'b' :
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
                break;
            case 'p' :
                if(order[0].charAt(1) == 'u') {
                   if(order[0].charAt(5) == 'f') deque.addFirst(order[1]);
                   else deque.addLast(order[1]);
                } else {
                    if(deque.isEmpty()) System.out.println(-1);
                    else {
                        if(order[0].charAt(4) == 'f') System.out.println(deque.pollFirst());
                        else System.out.println(deque.pollLast());
                    }
                }
        }
    }
}
