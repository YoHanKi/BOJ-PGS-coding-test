import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] CCW (11758) / 골드 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[4];
        int[] y = new int[4];
        for (int i = 1; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int CCW = (x[1]*y[2] + x[2]*y[3] + x[3]*y[1]) - (x[2]*y[1] + x[3]*y[2] + x[1]*y[3]);

        if (CCW < 0) System.out.println(-1);
        else if (CCW == 0) System.out.println(0);
        else System.out.println(1);


    }
}
