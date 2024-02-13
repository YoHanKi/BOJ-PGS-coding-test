import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        //배열처럼 st로 데이터를 받지 않고 받는 즉시 탐색 시작
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            //이진 탐색
            int start = 0;
            int end = arr.length - 1;
            //시작점과 끝점이 같을 때 까지 반복(즉, target을 찾으면 종료)
            while (start <= end) {
                //중앙 인덱스
                int middleI = (start + end) / 2;
                //중앙 값
                int middleV = arr[middleI];
                //중앙 값이 target보다 크면 기준을 좌측으로
                if(middleV > target) {
                    end = middleI - 1;
                    //중앙 값이 target보다 작으면 기준을 우측으로
                } else if(middleV < target) {
                    start = middleI + 1;
                } else {
                    //둘다 아닐 시 중앙값은 target과 같으므로 true
                    find = true;
                    break;
                }
            }
            if(find) System.out.println(1);
            else System.out.println(0);
        }

    }
}