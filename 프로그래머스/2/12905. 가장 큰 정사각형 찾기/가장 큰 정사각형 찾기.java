class Solution {
    public int solution(int[][] board) {
        int max = 0;
        
        //배열이 한개일 때, 예외처리
        if (board.length <= 1 || board[0].length <= 1) return 1;
        
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    board[i][j] += Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        
        return max * max;
    }
}