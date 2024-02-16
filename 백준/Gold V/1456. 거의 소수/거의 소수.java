import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAXIMUM_VALUE = 10000001;
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());
        br.close();

        boolean[] prime = new boolean[MAXIMUM_VALUE];

        //에라토스테네스의 체
        prime[0] = true; prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i] == true) continue;
            for (int j = i+i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }
        int count = 0;
        //범위 내 "거의 소수(소수의 제곱)"를 구한다.
        for (int i = 2; i < prime.length; i++) {
            if(prime[i] == false) {
                long tmp = i;
                while ((double)tmp <= (double)end/i) {
                    if((double)tmp >= (double)start/i) count++;
                    tmp *= i;
                }
                if((double) i > Math.sqrt(end)) break;
            }
        }
        System.out.println(count);
    }
}
