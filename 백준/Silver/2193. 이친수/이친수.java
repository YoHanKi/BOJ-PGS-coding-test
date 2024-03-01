import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [BOJ] 이친수 (2193) / 실버3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N+1][2];
        //하나의 자릿수에서 0일 때, 0개
        D[1][0] = 0;
        //1일 때, 1개
        D[1][1] = 1;
        for (int i = 2; i < D.length; i++) {
            //0일 경우, 1과 0이 올 수 있는 경우의 수
            D[i][0] = D[i-1][1] + D[i-1][0];
            //1일 경우, 1은 올 수 없으므로 0이 올 수 있는 경우의 수
            D[i][1] = D[i-1][0];
        }
        //자릿수의 0일 때와 1일 때의 경우의 수 합
        System.out.println(D[N][0]+D[N][1]);
    }
}
