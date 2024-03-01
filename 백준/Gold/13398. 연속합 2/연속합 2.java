import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 연속합2 (13398) / 골드 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //좌측부터의 합
        int[] L = new int[N];
        L[0] = A[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(A[i], L[i-1] + A[i]);
            result = Math.max(result, L[i]);
            //1개도 제거하지 않았을 때, 전체 합
        }
        //우측부터의 합
        int[] R = new int[N];
        R[N-1] = A[N-1];
        for (int i = N-2; i >= 0; i--) {
            R[i] = Math.max(A[i], R[i + 1] + A[i]);
        }
        //i번째 제거가 전체 합보다 크다면 결과에 저장
        for (int i = 1; i < N-1; i++) {
            //i 이전의 합(L[i - 1])과 i 이후의 합(R[i + 1])
            int tmp = L[i - 1] + R[i + 1];
            result = Math.max(result, tmp);
        }
        System.out.println(result);
    }
}
