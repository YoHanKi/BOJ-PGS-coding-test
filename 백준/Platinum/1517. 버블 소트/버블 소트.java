import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //재귀 함수 메서드를 사용하므로 static 선언
    static int[] arr, tmpArr;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmpArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;

        merge(0, N-1);

        System.out.println(result);
    }
    //병합 정렬
    private static void merge(int start, int end) {
        if(end - start < 1) return;
        int middle = ((end - start) / 2) + start;
        merge(start, middle);
        merge(middle+1, end);

        //임시 배열에 배열 복사
        for (int i = start; i <= end; i++) {
            tmpArr[i] = arr[i];
        }

        int saveIndexNum = start;
        int index1 = start;
        int index2 = middle+1;

        while (index1 <= middle && index2 <= end) {
            if(tmpArr[index1] > tmpArr[index2]) {
                arr[saveIndexNum] = tmpArr[index2];
                //나머지는 병합정렬과 동일하나 차이점은 이부분
                //원래 위치 index2와 저장배열 인덱스 위치의 차가 교환된 횟수이므로 result에 더해준다.
                result += (index2 - saveIndexNum);
                saveIndexNum++;
                index2++;
            } else {
                arr[saveIndexNum] = tmpArr[index1];
                saveIndexNum++;
                index1++;
            }
        }
        while (index1 <= middle) {
            arr[saveIndexNum] = tmpArr[index1];
            saveIndexNum++;
            index1++;
        }
        while (index2 <= end) {
            arr[saveIndexNum] = tmpArr[index2];
            saveIndexNum++;
            index2++;
        }
    }
}
