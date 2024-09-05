import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 반복된 숫자가 나올 가능성과, 이전 데이터를 사용하는 것이 효과적이라고 생각하여 DP 선택
 * -------------------------------------------------------------------------
 *
 */
public class Main {
    static String[] dp = new String[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = "-";
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            if(dp[N] == null) {
                cantoring(N);
            }
            System.out.println(dp[N]);
        }
    }
    public static void cantoring(int N) {
        for(int i = 1; i <= N; i++) {
            if(dp[i] != null) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(dp[i-1]).append(" ".repeat(dp[i-1].length())).append(dp[i-1]);
            dp[i] = sb.toString();
        }
    }
}
