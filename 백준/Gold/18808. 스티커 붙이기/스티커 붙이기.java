
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] notebook = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = st.nextToken().equals("1");
                }
            }

            boolean isAttached = false;
            for (int rotation = 0; rotation < 4; rotation++) {
                if (isAttached) break;
                for (int i = 0; i <= N - R; i++) {
                    if (isAttached) break;
                    for (int j = 0; j <= M - C; j++) {
                        if (canAttach(notebook, sticker, i, j)) {
                            attach(notebook, sticker, i, j);
                            isAttached = true;
                            break;
                        }
                    }
                }
                if (!isAttached) {
                    sticker = rotate(sticker);
                    int temp = R;
                    R = C;
                    C = temp;
                }
            }
        }
        int count = 0;
        for (boolean[] row : notebook) {
            for (boolean cell : row) {
                if (cell) count++;
            }
        }
        System.out.println(count);
    }

    public static boolean canAttach(boolean[][] notebook, boolean[][] sticker, int startX, int startY) {
        int R = sticker.length;
        int C = sticker[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] && notebook[startX + i][startY + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void attach(boolean[][] notebook, boolean[][] sticker, int startX, int startY) {
        int R = sticker.length;
        int C = sticker[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j]) {
                    notebook[startX + i][startY + j] = true;
                }
            }
        }
    }

    public static boolean[][] rotate(boolean[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;
        boolean[][] rotated = new boolean[C][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = sticker[i][j];
            }
        }
        return rotated;
    }
}
