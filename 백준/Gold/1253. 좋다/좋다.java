import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //투포인터 활용
        int count = 0;
        Arrays.sort(arr);
        //arr[i]를 기준으로 뒤쪽의 합이 arr[i]가 되는지 확인
        for (int i = 0; i < N; i++) {
            long search = arr[i];
            int start = 0;
            int end = N - 1;
            //교차되는 순간 종료
            while (start < end) {
                if(arr[start] + arr[end] == search) {
                    //arr[i]는 카운트하지 않는다.
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                } else if(arr[start] + arr[end] < search) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}