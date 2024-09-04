import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 해당 문제의 밭의 모양은 항상 동일하기 때문에, 가장 넓은 면의 높이와 길이를 구하고
 * 양 옆 길이의 차를 빼주어 빈공간의 넓이는 구하는 문제입니다.
 * ---------------------------------------------------------
 * 모든 순서를 담을 배열과 길이를 담을 배열을 선언
 * 문제의 밭 특성 상, 가장 큰 높이의 양옆의 차로 빈공간의 길이를 구할 수 있음
 * 동일하게 가진 큰 길이의 양옆의 차로 빈 공간의 높이를 구할 수 있음
 * 가장 넓은 넓이와 가장 좁은 넓이의 차와 참외의 값을 곱하여 값을 구함
 * ---------------------------------------------------------
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int melon = Integer.parseInt(st.nextToken());

        int[][] arr = new int[6][1];
        int MAX_HEIGHT = Integer.MIN_VALUE;
        int HEIGHT_INDEX = 0;
        int MAX_WIDTH = Integer.MIN_VALUE;
        int WIDTH_INDEX = 0;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[i][0] = length;
            switch (direction) {
                case 1 :
                case 2 :
                    if (length > MAX_WIDTH) {
                        MAX_WIDTH = length;
                        WIDTH_INDEX = i;
                    }
                    break;
                case 3 :
                case 4 :
                    if (length > MAX_HEIGHT) {
                        MAX_HEIGHT = length;
                        HEIGHT_INDEX = i;
                    }
                    break;
            }
        }
        // 최소 인덱스 0과 최대 인덱스 5를 고려하여 6을 더하고 6의 나머지를 구하여 인덱스 내에 위치하도록 계산
        int EMPTY_WIDTH = Math.abs(arr[(HEIGHT_INDEX+7)%6][0] - arr[(HEIGHT_INDEX+5)%6][0]);
        int EMPTY_HEIGHT = Math.abs(arr[(WIDTH_INDEX+7)%6][0] - arr[(WIDTH_INDEX+5)%6][0]);

        int result = ((MAX_WIDTH * MAX_HEIGHT) - (EMPTY_WIDTH * EMPTY_HEIGHT)) * melon;

        System.out.println(result);
    }
}
