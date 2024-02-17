import java.io.*;
import java.util.StringTokenizer;

/**
 * [BOJ] 최대공약수 (1850) / 실버 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        br.close();

        long result = gcd(a, b);

        while (result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }
    //최대공약수
    private static long gcd(long a, long b) {
        long remain;
        while(true) {
            remain = b % a;
            if(remain != 0) {
                b = a;
                a = remain;
            } else break;
        }
        return a;
    }
}
