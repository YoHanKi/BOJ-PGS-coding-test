import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();
        //일의 자리 소수는 2,3,5,7 뿐이므로 4개수 시작
        DFS(2, 1, N);
        DFS(3, 1, N);
        DFS(5, 1, N);
        DFS(7, 1, N);
    }
    //소수는 에라토스테네스의 체를 사용하여 풀 수 있지만, DFS로도 풀이 할 수 있다.
    private static void DFS(int num, int digit, int N) {
        //문제에서 주어진 자릿수와 DFS 자릿수가 같고
        if (digit == N) {
            //소수가 맞다면 출력
            if (isPrime(num)) System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            //짝수라면 패스
            if (i % 2 == 0) continue;
            //만약 *10+ 1~9 또한 소수라면, 재귀호출
            if (isPrime(num * 10 + i))
                DFS(num * 10 + i, digit + 1, N);
        }
    }
    // 소수 확인 함수
    private static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            //나머지가 0이라면 소수가 아님
            if (num % i == 0) return false;
        }
        return true;
    }
}