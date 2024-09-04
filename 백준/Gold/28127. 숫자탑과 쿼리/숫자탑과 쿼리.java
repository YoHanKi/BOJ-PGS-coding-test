import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학공식으로 다음 층의 첫번째 블럭 공식은
 * 이전 탑 첫 블럭 + (a + (현재층 높이 - 1) *d) 입니다.
 * 만약 x보다 크다면 찾으려는 블럭의 위치는 x - 첫 블럭의 값 + 1 이 됩니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int height = 1;
            int sum = 1;
            while (true) {
                int temp = a + ((height-1) * d);
                if(sum + temp > x) {
                    break;
                }
                sum += temp;
                height++;
            }

            System.out.println(height + " " + (x - sum + 1));
        }
    }
}
