import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] dp = new String[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0] = "-";
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            if(dp[N] == null) {
                for(int i = 1; i < dp.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(dp[i-1]).append(" ".repeat(dp[i-1].length())).append(dp[i-1]);
                    dp[i] = sb.toString();
                }
            }
            System.out.println(dp[N]);
        }
    }
}
