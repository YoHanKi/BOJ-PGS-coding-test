import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //투포인터 활용(일반적으로 투포인터는 정렬된 상태에서 용이하다.)
        Arrays.sort(arr);
        int count = 0;
        int stIndex = 0;
        int edIndex = N-1;
        //양끝에 포인터를 위치, st포인터가 ed Index를 넘어가면 종료
        while (stIndex < edIndex) {
            //정렬된 상태이므로 합이 M보다 작다면 st인덱스 증가
            if(arr[stIndex] + arr[edIndex] < M) {
                stIndex++;
                //합이 M보다 크다면 ed인덱스 감소
            } else if(arr[stIndex] + arr[edIndex] > M) {
                edIndex--;
            } else {
                //합이 M과 같다면 카운트, st인덱스 증가
                count++;
                stIndex++;
            }
        }
        System.out.println(count);
    }
}