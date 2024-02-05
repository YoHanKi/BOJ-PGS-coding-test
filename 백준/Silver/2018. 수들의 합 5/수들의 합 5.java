import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //투포인터 활용
        int stIndex = 1;
        int edIndex = 1;
        //N, 스스로는 합이 N이기 때문에 N을 제외하기 위해 count 1 부터 시작
        int count = 1;
        int sum = 1;
        //enIndex가 N이 된다면 종료
        while(edIndex != N) {
            //합이 N일 시 count++, edIndex 이동
            if(sum == N) {
                count++;
                edIndex++;
                sum += edIndex;
            }
            //합이 N보다 클 시 stIndex 이동
            else if (sum > N) {
                sum -= stIndex;
                stIndex++;
            } else {
                edIndex++;
                sum += edIndex;
            }
        }

        System.out.println(count);
    }
}