import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 조약돌 꺼내기 (13251) / 실버 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int T = 0;
        int D[] = new int[51];
        double probability[] = new double[51];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            T += D[i];
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        double ans = 0.0;
        for (int i = 0; i < M; i++) {
            if (D[i] >= K) {
                probability[i] = 1.0;
                for (int k = 0; k < K; k++)
                    probability[i] *= (double) (D[i] - k) / (T - k);
            }
                ans += probability[i];
        }
        System.out.println(ans);
    }
}
