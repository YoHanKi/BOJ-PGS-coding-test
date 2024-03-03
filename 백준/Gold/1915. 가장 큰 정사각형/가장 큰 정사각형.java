import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 가장 큰 정사각형 (1915) / 골드4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[][] D = new long[1001][1001];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long max = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                D[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
                //정사각형의 기준을 사각형 우측하단으로 측정하기 때문에 i,j가 0보다 커야함
                if (D[i][j] == 1 && i > 0 && j > 0) {
                    //탐색 중인 배열이 위측 배열과, 좌측 배열 중 작은 것과, 대각선 중 작은 값에 +1을 더하여 준다.
                    D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + D[i][j];
                }
                //만약 가장 큰 수라면 최신화
                if (max < D[i][j]) max = D[i][j];
            }
        }
        System.out.println(max*max);
    }
}
