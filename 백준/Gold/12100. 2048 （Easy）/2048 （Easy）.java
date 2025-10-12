
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = (num == 0) ? 0 : calculation(num, 2);
            }
        }

        DFS(board, 0);

        System.out.println((int) Math.pow(2, MAX));
    }

    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    static int MAX = 0;

    public static int calculation(int num, int pow) {
        if (num <= 0) return -1;
        int k = 0;
        while (num % pow == 0) {
            num /= pow;
            k++;
        }
        return (num == 1) ? k : -1;
    }

    public static void DFS(int[][] board, int depth) {
        if (depth == 5) {
            for (int[] row : board) {
                for (int num : row) {
                    MAX = Math.max(MAX, num);
                }
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] newBoard = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                System.arraycopy(board[i], 0, newBoard[i], 0, board[0].length);
            }
            move(newBoard, dir);
            DFS(newBoard, depth + 1);
        }
    }

    public static void move(int[][] board, int dir) {
        int n = board.length;
        switch(dir) {
            case UP:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index - 1][i]++;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case DOWN:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(block == board[j][i]) {
                                board[index + 1][i]++;
                                block = 0;
                                board[j][i] = 0;
                            }
                            else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case LEFT:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index - 1]++;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case RIGHT:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(block == board[i][j]) {
                                board[i][index + 1]++;
                                block = 0;
                                board[i][j] = 0;
                            }
                            else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
}