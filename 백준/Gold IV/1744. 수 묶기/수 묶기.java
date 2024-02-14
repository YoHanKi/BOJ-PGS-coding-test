import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //음수 우선순위 큐
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        //양수 우선순위 큐
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Comparator.reverseOrder());
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) {
                plusPq.add(num);
            } else if ( num == 0 ) {
                zero++;
            } else if ( num == 1 ) {
                one++;
            } else {
                minusPq.add(num);
            }
        }

        int sum = 0;
            //양수 처리
        while (plusPq.size() > 1) {
                int first = plusPq.remove();
                int second = plusPq.remove();
                sum += (first * second);
            }
            if(!plusPq.isEmpty()) {
                sum += plusPq.remove();
            }
            
            //음수처리
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum += (first * second);
        }
        if(!minusPq.isEmpty()) {
            if(zero == 0) sum += minusPq.remove();
        }
        //남은 1을 더해준다.
        sum += one;
        System.out.println(sum);
    }
}
