import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀 함수 사용
 * -----------------------------------------------------------
 * 문제에서 가장 작은 범위에서 이동 순서는 좌상, 우상, 좌하단, 우하단 순
 * 재귀 함수를 사용하여 찾는 범위가 1이 될때까지 순서대로 들어가며 count++
 * -----------------------------------------------------------
 */
public class Main {
    static int count = 0;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int range = (int)Math.pow(2, N);

        recursion(r, c, 0, 0, range);
    }

    public static void recursion(int r, int c, int x, int y, int range) {
        if (found) return;
        if(range <= 1) {
            count++;
            if(y==r && x == c) {
                found = true;
                System.out.println(count-1);
            }
            return;
        }

        int half = range/2;

        // 좌상단 영역
        if (r < y + half && c < x + half) {
            recursion(r, c, x, y, half);
        }
        // 우상단 영역
        else if (r < y + half && c >= x + half) {
            count += half * half;  // 이미 지나친 좌상단 영역의 칸 수를 더함
            recursion(r, c, x + half, y, half);
        }
        // 좌하단 영역
        else if (r >= y + half && c < x + half) {
            count += 2 * half * half;  // 이미 지나친 좌상단, 우상단 영역의 칸 수를 더함
            recursion(r, c, x, y + half, half);
        }
        // 우하단 영역
        else {
            count += 3 * half * half;  // 이미 지나친 좌상단, 우상단, 좌하단 영역의 칸 수를 더함
            recursion(r, c, x + half, y + half, half);
        }
    }
}
