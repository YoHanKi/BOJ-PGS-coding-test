import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //그리디 알고리즘
        for (int i = N - 1 ; i >= 0; i--) {
            //가장 큰 금액의 동전으로 거슬러 줄 수 있다면
            if (arr[i] <= K) {
                //가장 큰 금액으로 나눈 값이 동전의 갯수
                count += (K/arr[i]);
                //나머지를 잔돈으로 치환
                K = K % arr[i];
            }
        }
        System.out.println(count);
    }
}