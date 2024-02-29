import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [BOJ] 선물 전달(1947) / 골드 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long MOD = 1_000_000_000L;
        long[] D = new long[1000001];
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            //완전 순열 공식 (n! = (n-1) * ((n-1)! + (n-2)!))
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD;
        }
        System.out.println(D[N]);
    }
}
