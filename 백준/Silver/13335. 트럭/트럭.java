import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int bridgeWeight = 0;

        for (int i = 0; i < W; i++) deque.add(0);

        int time = 0;
        while (!deque.isEmpty()) {
            time++;
            bridgeWeight -= deque.poll();
            if (index < N) {
                if (bridgeWeight + trucks[index] <= L) {
                    bridgeWeight += trucks[index];
                    deque.add(trucks[index]);
                    index++;
                } else deque.add(0);
            }
        }
        System.out.println(time);
    }
}