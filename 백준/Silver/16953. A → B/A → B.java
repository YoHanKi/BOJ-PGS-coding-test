import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int ans = 1;
        while (B != A) {
            if (B < A) {
                ans = -1;
                break;
            }

            String str = String.valueOf(B);

            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                ans = -1;
                break;
            }

            if (B % 2 == 0) {
                B >>= 1;
            } else {
                str = str.substring(0, str.length() - 1);
                B = Long.parseLong(str);
            }

            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
