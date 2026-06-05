
class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String base = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nx = h+dx[i];
            int ny = w+dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (base.equals(board[nx][ny])) {
                answer++;
                }
            }
        }
        return answer;
    }
}