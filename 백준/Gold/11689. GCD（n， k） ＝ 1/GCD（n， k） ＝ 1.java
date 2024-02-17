import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [BOJ] GCD(n, k) = 1 (11689) / 골드 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //오일러 피(파이) 함수 문제
        long N = Long.parseLong(br.readLine());
        long result = N;
        //실제 배열을 생성하면 메모리 문제 및 시간초과가 발생한다.
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                result = result - result/i;
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        //제곱근까지만 처리했으므로 1개가 누락되므로 처리해야한다(ex. 소수는 자기자신)
        if (N > 1) result = result - result/N;
        System.out.println(result);
    }
}
