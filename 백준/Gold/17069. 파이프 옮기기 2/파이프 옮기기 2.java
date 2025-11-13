import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
            }
        }
        long[][][] dp = new long[N][N][3];
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) continue;
                if (j - 1 >= 0) {
                    dp[i][j][0] += dp[i][j - 1][0];
                    dp[i][j][0] += dp[i][j - 1][2];
                }
                if (i - 1 >= 0) {
                    dp[i][j][1] += dp[i - 1][j][1];
                    dp[i][j][1] += dp[i - 1][j][2];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp[i][j][2] += dp[i - 1][j - 1][0];
                        dp[i][j][2] += dp[i - 1][j - 1][1];
                        dp[i][j][2] += dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        long result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(result);
    }
}