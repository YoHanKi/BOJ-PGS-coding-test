import java.util.*;

class Solution {
    public static int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        char[][] grid = new char[rows][cols];
        int startX = 0, startY = 0, goalX = 0, goalY = 0;

        for (int i = 0; i < rows; i++) {
            grid[i] = board[i].toCharArray();
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'R') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        return bfs(grid, startX, startY, goalX, goalY);
    }

    public static int dfs(char[][] grid, boolean[][] visited, int x, int y, int goalX, int goalY, int moves) {
        if (x == goalX && y == goalY) return moves;

        visited[x][y] = true;
        int minMoves = Integer.MAX_VALUE;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int newX = x;
            int newY = y;

            while (true) {
                int nextX = newX + dir[0];
                int nextY = newY + dir[1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || grid[nextX][nextY] == 'D') {
                    break;
                }
                newX = nextX;
                newY = nextY;
            }

            if (!visited[newX][newY]) {
                int result = dfs(grid, visited, newX, newY, goalX, goalY, moves + 1);
                if (result != -1) {
                    minMoves = Math.min(minMoves, result);
                }
            }
        }

        visited[x][y] = false;
        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }

    public static int bfs(char[][] grid, int startX, int startY, int goalX, int goalY) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            if (x == goalX && y == goalY) {
                return moves;
            }

            for (int[] dir : directions) {
                int newX = x;
                int newY = y;

                while (newX + dir[0] >= 0 && newX + dir[0] < rows &&
                        newY + dir[1] >= 0 && newY + dir[1] < cols &&
                        grid[newX + dir[0]][newY + dir[1]] != 'D') {
                    newX += dir[0];
                    newY += dir[1];
                }

                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, moves + 1});
                }
            }
        }

        return -1;
    }
}