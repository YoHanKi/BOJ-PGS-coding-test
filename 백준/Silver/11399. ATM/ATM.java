import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] preSum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //삽입정렬
        for (int i = 1; i < N; i++) {
            //정렬 대상의 인덱스와 값을 지정
            int index = i;
            int value = arr[i];
            //정렬 대상 이전, 정렬되어있는 값과 비교하여
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    //정렬 대상이 더 크면 인덱스는 j보다 무조건 크므로 j+1
                    index = j + 1;
                    break;
                }
                //정렬 대상보다 작거나, j가 0이라면 인덱스는 0
                if(j == 0) {
                    index = 0;
                }
            }
            //삽입된 배열을 한칸씩 이동 시킨다.
            for (int j = i; j > index; j--) {
                arr[j] = arr[j-1];
            }
            //배열 이동 후 삽입
            arr[index] = value;
        }
        //0번째 배열은 합배열에 추가할 필요없이 초기화
        preSum[0] = arr[0];
        //합배열
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }
        int TotalSum = 0;
        for (int i = 0; i < N; i++) {
            TotalSum = TotalSum + preSum[i];
        }
        System.out.println(TotalSum);
    }
}