import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 고층 빌딩 (1328) / 플레티넘5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long MOD = 1000000007;
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[][][] D = new long[101][101][101];
        D[1][1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    //중간에 들어갈 수 있는 경우의 수 + 가장 우측에 들어간 경우의 수 + 가장 좌측에 들어간 경우의 수
                    D[i][j][k] = (D[i-1][j][k] * (i - 2) + (D[i-1][j][k-1] + D[i-1][j-1][k])) % MOD;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}
