import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 플로이드 (11404) / 골드4
 * 플로이드 워셜 문제
 */
public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        //인접행렬로 구현하기 위해 자기자신은 0, 나머지는 최대치로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) arr[i][j] = 0;
                //MAX_VALUE 사용 시 플루이드 워셜 알고리즘에서 + 연산자로 인해 오버플로가 발생한다.
                else arr[i][j] = 10000001;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (arr[s][e] > v) arr[s][e] = v;
        }
        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (arr[s][e] > arr[s][k] + arr[k][e]) arr[s][e] = arr[s][k] + arr[k][e];
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 10000001) System.out.print("0 ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
