import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if(score[i] > max) max = score[i];
            sum += score[i];
        }

        System.out.println(sum * 100.0 / max / N);
    }
}
