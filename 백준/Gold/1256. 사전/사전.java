import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 사전 (1256) /골드 2
 */
public class Main {
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        D = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                //D[i][0] 이거나, D[i][i] 이라면 1 -> 조합 생성식
                if (j == 0 || j == i) D[i][j] = 1;
                else {
                    D[i][j] = D[i-1][j] + D[i-1][j-1];
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001;
                }
            }
        }
        if (D[N+M][M] < K) System.out.println("-1");
        else {
            while (!(N == 0 && M == 0)) {
                if (D[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - D[N - 1 + M][M];
                    M--;
                }
            }
        }
    }
}
