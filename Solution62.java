package beginner;

//안전지대
class Solution62 {
	    public static int solution(int[][] board) {
	        int row = board.length;     //2차원 배열의 가독성을 위해 row로 지정
	        int col = board[0].length;  //2차원 배열의 가독성을 위해 col로 지정
	        int safeCount = 0;

	        // 먼저 지뢰가 있는 위치 주변을 위험 지역으로 표시
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (board[i][j] == 1) {
	                    markDangerous(board, i, j);
	                }
	            }
	        }

	        // 지뢰 주변에 위험 지역을 제외한 안전한 지역의 칸 수 세기
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (board[i][j] == 0) {
	                    safeCount++;
	                }
	            }
	        }

	        return safeCount;
	    }
	    //위험 지역을 판단하는 메소드
	    private static void markDangerous(int[][] board, int row, int col) {
	        //dr은 DangerRow로 폭탄을 기준으로 x,y 상 위치를 나타낸 배열
	        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	        //dc는 DangerCol로 폭탄을 기준으로 x,y 상 위치를 나타낸 배열
	        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	        for (int i = 0; i < 8; i++) {
	            //폭탄의 위치(row) 를 기준으로 dr[i]의 위치에 nr(nearRow) 지정
	            int nr = row + dr[i];
	            //폭탄의 위치(col) 를 기준으로 dc[i]의 위치에 nc(nearCol) 지정
	            int nc = col + dc[i];

	            // 범위를 벗어나지 않는지 확인하고 주변 칸을 위험지역으로 표시
	            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 0) {
	                board[nr][nc] = -1;
	            }
	        }
	    }
	}