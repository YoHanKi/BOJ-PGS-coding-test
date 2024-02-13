import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //생각치도 못한 풀이 방법이였다..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long start = 1, end = K;
        long answer = 0;

        //이진탐색
        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 0;
            //중앙값보다 작은 수 계산
            for (int i = 1; i <= N; i++) {
                //작은 수를 카운트 하는 핵심 로직
                count += Math.min(middle/i , N);
            }
            if (count < K) {
                start = middle + 1;
            } else {
                answer = middle;
                end = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
