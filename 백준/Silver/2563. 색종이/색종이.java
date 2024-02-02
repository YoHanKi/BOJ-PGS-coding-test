import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //문제의 범위만큼 2차원 배열 생성
        boolean[][] map = new boolean[101][101];
        int count = 0;

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = y; j < y+10; j++) {
                for (int k = x; k < x+10; k++) {
                    //색종이의 범위만큼 true로 변경, true일 시, true면 count를 증가 
                    if(!map[j][k]) {
                        map[j][k] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
