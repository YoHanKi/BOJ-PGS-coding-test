import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 재귀를 사용해서 문제를 해결했습니다.
 * -----------------------------------------------------
 * 범위에 해당하는 부분만 빈칸으로 변경합니다.
 * 모든 범위에 적용되도록 3,3 반복문으로 반복합니다.
 * i,j = 1은 중앙 부근이므로 이미 빈칸 처리 되어 있어 넘어갑니다.
 * -----------------------------------------------------
 */
public class Main {
    static char[][] patterns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        patterns = new char[N][N];
        for (char[] pattern : patterns) {
            Arrays.fill(pattern, '*');
        }

        recursion(0, 0, N);

        for (char[] pattern : patterns) {
            System.out.println(pattern);
        }
    }

    // 재귀 호출 시 현재 시작 위치와 패턴의 크기를 전달
    public static void recursion(int x, int y, int range) {
        if (range == 1) return;

        int oneThird = range / 3;

        // 중앙 부분을 공백으로 채움
        for (int i = x + oneThird; i < x + 2 * oneThird; i++) {
            for (int j = y + oneThird; j < y + 2 * oneThird; j++) {
                patterns[i][j] = ' ';
            }
        }

        // 9개의 작은 사각형에 대해 재귀 호출
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 중앙 부분 제외
                if (i == 1 && j == 1) continue;
                recursion(x + i * oneThird, y + j * oneThird, oneThird);
            }
        }
    }
}
