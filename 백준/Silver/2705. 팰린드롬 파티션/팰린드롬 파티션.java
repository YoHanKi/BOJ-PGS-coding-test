import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀 접근은 판단이 되지 않아 DP 로 해결
 * ---------------------------------------------
 * 자기 자신은 항상 포함하고 있기 때문에 1을 더해줍니다.
 * 현재 숫자의 절반까지의 dp와 자기자신을 더합니다.
 * ---------------------------------------------
 */
public class Main {
    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[MAX + 1];

        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i/2; j++) {
                dp[i] += dp[j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
