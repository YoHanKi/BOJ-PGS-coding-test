import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //우선순위 큐를 사용한 탐욕법
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }
        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        
        while (priorityQueue.size() != 1) {
            data1 = priorityQueue.remove();
            data2 = priorityQueue.remove();
            sum += (data1 + data2);
            priorityQueue.add(data1+data2);
        }
        System.out.println(sum);
    }
}