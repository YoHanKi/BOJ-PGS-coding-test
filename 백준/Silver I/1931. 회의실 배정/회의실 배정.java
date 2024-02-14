import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //겹치지 않는 회의에는 바로 끝나는 회의가 있을 수 있다. 바로 끝나는 회의가 뒤로갈수 있게 정렬 기준 제작
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if(S[1] == E[1]) {
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });
        int count = 0;
        //회의가 끝나는 시간 초기화
        int end = -1;
        for (int i = 0; i < N; i++) {
            //이전 회의의 끝나는 시간이 다음 회의 시작 시간과 맞다면
            if(arr[i][0] >= end) {
                //다음 회의 시간을 end로 설정, 다음 배열과 비교
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
