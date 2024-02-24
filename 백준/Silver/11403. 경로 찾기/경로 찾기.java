import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 경로 찾기 (11403) / 실버 1
 */
public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //플루이드 워셜 응용
        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    //시작점과 중간, 중간과 도착점이 연결되어 있다면, 시작점과 도착점은 연결되어 있다.
                    if (arr[s][m] == 1 && arr[m][e] == 1) arr[s][e] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
