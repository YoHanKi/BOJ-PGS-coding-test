import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 제곱 ㄴㄴ수 (1016) / 골드 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] arr = new boolean[(int) (max - min + 1)];

        //에라토스테네스의 체와 같은 방식으로 계산
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long rangeIndex = min / pow;
            //나누어 떨어지지 않는다는 건 제곱수가 아닌것이므로 1을 더함.
            if(min % pow != 0) rangeIndex++;
            //제곱ㄴㄴ수를 구하지않고, 제곱수를 구한다.
            for (long j = rangeIndex; j * pow <= max; j++) {
                arr[(int) ((j * pow) - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i]) count++;
        }
        System.out.println(count);
    }
}
