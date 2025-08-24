import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] data;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        data = new int[n][n];
        // 배열 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = data[n - 1][i];
        }

        int result = DP(0, 0);

        System.out.println(result);
    }

    public static int DP(int depth, int step) {
        if (depth  == data.length - 1) {
            return dp[depth][step];
        }

        if (dp[depth][step] == null) {
            dp[depth][step] = Math.max(DP(depth + 1, step), DP(depth + 1, step + 1)) + data[depth][step];
        }
        return dp[depth][step];
    }
}