import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] pre = new long[N];
        long[] rmd = new long[M];
        long result = 0L;


        st = new StringTokenizer(br.readLine());
        pre[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) { //합배열 만들기
            pre[i] = pre[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            //합배열에 % M 연산 실행
            int remainder = (int) (pre[i] % M);
            //연산 이후 나머지가 0과 같다면 result++
            if (remainder == 0) result++;
            //나머지가 같은 인덱스의 수를 카운트(나머지는 M의 배열만큼 존재)
            rmd[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if(rmd[i] > 1) {
                //서로 다른 rmd[i] * (rmd[i] - 1)개에서 2개를 고르는 조합 일반식
                result = result + (rmd[i] * (rmd[i] - 1) / 2);
            }
        }
        System.out.println(result);
    }
}