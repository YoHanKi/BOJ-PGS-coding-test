import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [BOJ] 부녀회장이 될테야 (2775) / 브론즈 1
 */
public class Main {
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        D = new int[15][15];
        for (int i = 0; i < D.length; i++) {
            D[0][i] = i;
            D[i][1] = 1;
        }
        for (int i = 1; i < D.length; i++) {
            for (int j = 2; j < D.length; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1];
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(D[k][n]);
        }

    }
}
