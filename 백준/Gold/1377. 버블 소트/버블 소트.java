import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ComData[] arr = new ComData[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ComData(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(arr);

        int Max = 0;
        //기존 배열 인덱스와 현재 인덱스의 차이를 통해 얼마나 이동했는지 알 수 있다.
        for (int i = 0; i < N; i++) {
            if(Max < arr[i].index - i)
                Max = arr[i].index - i;
        }
        //배열은 0부터 시작이므로 +1을 더해준다.
        System.out.println(Max + 1);
    }

    private static class ComData implements Comparable<ComData> {
        int value;
        int index;

        ComData(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }
        //value 기준 오름차순 정렬 생성
        @Override
        public int compareTo(ComData o) {
            return this.value - o.value;
        }
    }
}