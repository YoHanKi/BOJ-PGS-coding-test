
import java.io.*;

public class Main {
    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(br.readLine().replaceAll(",", ""));
            long[][] result = {{1, 0}, {0, 1}};
            long[][] fibMatrix = {{1, 1}, {1, 0}};
            n -= 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    result = multiplyMatrices(result, fibMatrix);
                }
                fibMatrix = multiplyMatrices(fibMatrix, fibMatrix);
                n /= 2;
            }
            System.out.println(result[0][0] % MOD);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (a[i][0] * b[0][j] + a[i][1] * b[1][j]) % MOD;
            }
        }
        return c;
    }
}
