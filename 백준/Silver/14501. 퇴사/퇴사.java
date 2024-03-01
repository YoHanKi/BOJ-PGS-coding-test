import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 퇴사 (14501) / 실버 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+2];
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            //일을 마친 날짜가 퇴사 날짜 보다 크다면 앞선 날짜만 추가
            if (i + T[i] > N + 1) D[i] = D[i + 1];
            //일을 마친 날짜가 퇴사 날짜 보다 작다면 비교 하여 저장
            else D[i] = Math.max(D[i + 1],P[i] + D[i + T[i]]);
        }
        System.out.println(D[1]);
    }
}
