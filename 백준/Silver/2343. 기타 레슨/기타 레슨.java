import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > start) start = arr[i];
            end += arr[i];
        }
        //이진탐색(블루레이CD의 최소범위 start부터 최대범위 end까지 값을 비교하여 탐색)
        while (start <= end) {
            //이진탐색에서 최소값과 최대값의 중간값을 지정
            int middle = (start + end) /2;
            int sum = 0;
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                //레슨비디오의 합과 현재 배열의 합이 중간값보다 크다면
                if((sum + arr[i]) > middle) {
                    //CD가 추가로 필요하므로 count++
                    count++;
                    //CD를 다시 추가하므로 합을 0으로 초기화
                    sum = 0;
                }
                //크지 않다면 현재 배열을 합함
                sum += arr[i];
            }
            //N번의 반복문을 돌았을때, sum이 0이 아니라면 CD가 추가로 필요하므로 count++
            if (sum != 0) count++;
            //count가 M보다 크다면 더 큰 블루레이 CD 크기가 필요하므로 우측 이동
            if (count > M) start = middle + 1;
            //count가 M보다 작다면 더 작은 블루레이 CD 크기가 필요하므로 좌측 이동
            else end = middle - 1;
        }
        System.out.println(start);
    }
}