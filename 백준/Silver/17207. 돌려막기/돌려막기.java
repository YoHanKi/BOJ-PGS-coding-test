import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] member = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] A = new int[5][5];

        for(int i = 0; i < A.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < A[i].length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] B = new int[5][5];
        for(int i = 0; i < B.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < B[i].length; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] C = new int[5];
        for(int c = 0;c < 5; c++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    C[c] += A[c][j] * B[j][i];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < C.length; i++) {
            if(min >= C[i]) {
                min = C[i];
                index = i;
            }
        }

        System.out.println(member[index]);
    }
}
