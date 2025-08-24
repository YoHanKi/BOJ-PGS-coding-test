import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
입력 :
2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80

결과 :
260
290
*/
public class Main {
    private static int[][] sticker;
    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int step = 0; step < T; step++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            sticker = new int[2][N];
            dp = new Integer[2][N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i-1], i == 1 ? dp[1][i-1] : dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], i == 1 ? dp[0][i-1] : dp[0][i-2]) + sticker[1][i];
            }

            sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
        }
        System.out.println(sb);
    }
}
