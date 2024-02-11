import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];
        //String으로 받은 문제를 배열로 변환
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        //선택정렬
        for (int i = 0; i < str.length(); i++) {
            //인덱스로 비교하기 때문에 초기화를 i로 진행한다.
            int Max = i;
            for (int j = i+1; j < str.length(); j++) {
                //최대값을 찾는다.
                if(arr[j] > arr[Max]) Max = j;
            }
            //가장 앞 배열이 Max보다 작으면 교환
            if(arr[i] < arr[Max]) {
                int tmp = arr[i];
                arr[i] = arr[Max];
                arr[Max] = tmp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}