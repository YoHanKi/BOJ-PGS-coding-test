import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [BOJ] 2 x n 타일링 (11726) / 실버 3
 */
public class Main {
    static long[] D;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D = new long[1001];

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i < D.length; i++) {
            D[i] = (D[i-1] + D[i-2]) % MOD;
        }

        int N = Integer.parseInt(br.readLine());

        System.out.println(D[N]);
     }
}
