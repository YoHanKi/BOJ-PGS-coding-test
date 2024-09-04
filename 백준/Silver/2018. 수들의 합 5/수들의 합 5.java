import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;
        int left = 1;
        int right = 1;
        while(right != N) {
            if(sum == N) {
                count++;
                sum += ++right;
            } else if(sum < N) {
                sum += ++right;
            } else {
                sum -= left++;
            }
        }

        System.out.println(count);
    }
}
