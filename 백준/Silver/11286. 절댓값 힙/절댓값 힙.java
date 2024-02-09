import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //우선순위 큐를 사용. 우선순위큐는 선언 시 람다식을 통해 정렬 기준을 정할 수 있다
        PriorityQueue<Integer> priorQue = new PriorityQueue<>((num1, num2) -> {
           int first_abs = Math.abs(num1);
           int second_abs = Math.abs(num2);
           //절대값을 비교했을 때, 값이 같다면 음수 우선 정렬
           if (first_abs == second_abs) return num1 > num2 ? 1 : -1;
           //다르다면 절대값 기준 정렬
           else return first_abs - second_abs;
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            //만약 입력 값이 0이라면
            if(num == 0) {
                //큐가 비어 있을 경우 0출력
                if(priorQue.isEmpty()) System.out.println("0");
                else System.out.println(priorQue.poll());
            } else {
                priorQue.add(num);
            }
        }

    }
}