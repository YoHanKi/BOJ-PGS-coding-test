
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (T-- > 0) {
            map = spread(R, C, map);
            map = operateAirPurifier(R, C, map);
        }

        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    totalDust += map[i][j];
                }
            }
        }
        System.out.println(totalDust);
    }

    private static int[][] spread(int R, int C, int[][] map) {
        int[][] newMap = new int[R][C];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int spreadAmount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] != -1) {
                            newMap[ni][nj] += spreadAmount;
                            spreadCount++;
                        }
                    }

                    newMap[i][j] += map[i][j] - (spreadAmount * spreadCount);
                } else if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                }
            }
        }

        return newMap;
    }

    private static int[][] operateAirPurifier(int R, int C, int[][] map) {
        int[][] newMap = new int[R][C];
        int upperPurifierRow = -1;
        int lowerPurifierRow = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    if (upperPurifierRow == -1) {
                        upperPurifierRow = i;
                    } else {
                        lowerPurifierRow = i;
                    }
                }
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = upperPurifierRow - 1; i > 0; i--) newMap[i][0] = map[i - 1][0];
        for (int j = 0; j < C - 1; j++) newMap[0][j] = map[0][j + 1];
        for (int i = 0; i < upperPurifierRow; i++) newMap[i][C - 1] = map[i + 1][C - 1];
        for (int j = C - 1; j > 1; j--) newMap[upperPurifierRow][j] = map[upperPurifierRow][j - 1];
        newMap[upperPurifierRow][1] = 0;

        for (int i = lowerPurifierRow + 1; i < R - 1; i++) newMap[i][0] = map[i + 1][0];
        for (int j = 0; j < C - 1; j++) newMap[R - 1][j] = map[R - 1][j + 1];
        for (int i = R - 1; i > lowerPurifierRow; i--) newMap[i][C - 1] = map[i - 1][C - 1];
        for (int j = C - 1; j > 1; j--) newMap[lowerPurifierRow][j] = map[lowerPurifierRow][j - 1];
        newMap[lowerPurifierRow][1] = 0;

        return newMap;
        }
}