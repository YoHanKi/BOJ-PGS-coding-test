import java.util.*;

public class Main {
    static int N;
    static String[] tokens;
    static boolean[] bracket;
    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String expr = sc.next();

        tokens = new String[N];
        bracket = new boolean[N];

        // 한 글자씩 잘라서 토큰화
        for (int i = 0; i < N; i++) {
            tokens[i] = String.valueOf(expr.charAt(i));
        }

        dfs(1);

        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx >= N) {
            long val = evaluate();
            if (val > answer) {
                answer = val;
            }
            return;
        }

        dfs(idx + 2);

        if (idx - 2 < 0 || !bracket[idx - 2]) {
            bracket[idx] = true;
            dfs(idx + 2);
            bracket[idx] = false;
        }
    }

    static long evaluate() {
        String[] cur = tokens.clone();

        for (int i = 1; i < N; i += 2) {
            if (bracket[i]) {
                long a = Long.parseLong(cur[i - 1]);
                long b = Long.parseLong(cur[i + 1]);
                char op = cur[i].charAt(0);

                long res = apply(a, b, op);
                cur[i] = Long.toString(res);
                cur[i - 1] = null;
                cur[i + 1] = null;
            }
        }

        for (int i = 1; i < N; i += 2) {
            if (cur[i] != null && cur[i].equals("*")) {
                int left = i - 1;
                int right = i + 1;

                while (left >= 0 && cur[left] == null) left--;
                while (right < N && cur[right] == null) right++;

                long a = Long.parseLong(cur[left]);
                long b = Long.parseLong(cur[right]);

                long res = apply(a, b, '*');
                cur[i] = Long.toString(res);
                cur[left] = null;
                cur[right] = null;
            }
        }

        for (int i = 1; i < N; i += 2) {
            if (cur[i] != null && (cur[i].equals("+") || cur[i].equals("-"))) {
                int left = i - 1;
                int right = i + 1;

                while (left >= 0 && cur[left] == null) left--;
                while (right < N && cur[right] == null) right++;

                long a = Long.parseLong(cur[left]);
                long b = Long.parseLong(cur[right]);
                char op = cur[i].charAt(0);

                long res = apply(a, b, op);
                cur[i] = Long.toString(res);
                cur[left] = null;
                cur[right] = null;
            }
        }

        for (int i = 0; i < N; i++) {
            if (cur[i] != null) {
                return Long.parseLong(cur[i]);
            }
        }
        return 0;
    }

    static long apply(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            default: return a * b;
        }
    }
}
