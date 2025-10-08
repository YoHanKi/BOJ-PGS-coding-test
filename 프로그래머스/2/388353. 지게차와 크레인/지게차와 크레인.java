class Solution {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static int answer, rows, cols;

    public static int solution(String[] storage, String[] requests) {
        rows = storage.length;
        cols = storage[0].length();
        answer = rows * cols;
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 1) {
                boolean[][] visited = new boolean[rows][cols];
                for (int i = 0; i < rows; i++) {
                    if (!visited[i][0]) dfs(grid, visited, i, 0, target);
                    if (!visited[i][cols - 1]) dfs(grid, visited, i, cols - 1, target);
                }
                for (int j = 0; j < cols; j++) {
                    if (!visited[0][j]) dfs(grid, visited, 0, j, target);
                    if (!visited[rows - 1][j]) dfs(grid, visited, rows - 1, j, target);
                }
            } else removeAll(grid, target);
        }
        return answer;
    }

    public static void removeAll(char[][] grid, char target) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == target) {
                    answer--;
                    grid[i][j] = '.';
                }
            }
        }
    }

    public static void dfs(char[][] grid, boolean[][] visited, int x, int y, char target) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (grid[x][y] == '.') {
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                dfs(grid, visited, nx, ny, target);
            }
        }
        if (grid[x][y] == target) {
            answer--;
            grid[x][y] = '.';
        }
    }
}