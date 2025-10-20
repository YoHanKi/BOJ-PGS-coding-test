
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[6];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        StringBuilder sb = new StringBuilder();
        String[] commands = br.readLine().split(" ");
        for (int k = 0; k < K; k++) {
            int command = Integer.parseInt(commands[k]) - 1;
            int nx = x + dx[command];
            int ny = y + dy[command];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            int top = dice[0], bottom = dice[1], north = dice[2], south = dice[3], east = dice[4], west = dice[5];
            switch (command) {
                case 0: // East
                    dice[0] = west;
                    dice[1] = east;
                    dice[4] = top;
                    dice[5] = bottom;
                    break;
                case 1: // West
                    dice[0] = east;
                    dice[1] = west;
                    dice[4] = bottom;
                    dice[5] = top;
                    break;
                case 2: // North
                    dice[0] = south;
                    dice[1] = north;
                    dice[2] = top;
                    dice[3] = bottom;
                    break;
                case 3: // South
                    dice[0] = north;
                    dice[1] = south;
                    dice[2] = bottom;
                    dice[3] = top;
                    break;
            }

            x = nx;
            y = ny;

            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice[0]).append('\n');
        }
        System.out.print(sb);
    }
}