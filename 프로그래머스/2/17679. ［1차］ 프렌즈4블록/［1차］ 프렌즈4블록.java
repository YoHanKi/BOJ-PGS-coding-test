class Solution {
    public int solution(int m, int n, String[] board) {
        boolean[][] check;
        char[][] charBoard = new char[board.length][];
        for (int i = 0; i < board.length; i++) charBoard[i] = board[i].toCharArray();
        
        int answer = 0;
        while(true) {
            check = new boolean[m][n];
            //m-1, n-1만큼만 순회하며 우측,하단,우하단이 같은지 확인
            for(int i = 0; i < charBoard.length - 1; i++) {
                for(int j = 0; j < charBoard[i].length - 1; j++) {
                    char current = charBoard[i][j];
                    if(current != ' ' && current == charBoard[i][j+1] && 
                       current == charBoard[i+1][j] && current == charBoard[i+1][j+1]) {
                       //같다면 boolean 배열에 저장
                       check[i][j] = true; check[i][j+1] = true; check[i+1][j] = true; check[i+1][j+1] = true;
                    }
                }
            }
            
            int remove = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) {
                        charBoard[i][j] = ' ';  // 블록 제거
                        remove++;  // 제거된 블록 수 증가
                    }
                }
            }

            // 블록이 제거되지 않았다면 종료
            if(remove == 0) break;
            answer += remove;
            
            
            //boolean을 역순으로 순회하며 true라면, false를 만날때까지 상단으로 이동
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i >= 0; i--) {
                    if(charBoard[i][j] == ' ') {
                        int row = i - 1;
                        while(row >= 0 && charBoard[row][j] == ' ') {
                            row--;  // 빈 공간 위쪽으로 계속 탐색
                        }
                        if(row >= 0) {  // 위에 블록이 있다면
                            charBoard[i][j] = charBoard[row][j];  // 블록을 떨어뜨림
                            charBoard[row][j] = ' ';  // 떨어진 블록 자리를 빈 공간으로 만듦
                        }
                    }
                }
            }
        }
        return answer;
    }
}

// for(boolean[] bo : check) {
//             for(boolean b : bo) {
//                 if(b) System.out.print("1 ");
//                 else System.out.print("0 ");
//             }
//             System.out.println();
//         }