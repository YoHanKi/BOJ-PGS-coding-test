class Solution {
    int[][] roadMap;
    
    public int solution(int m, int n, int[][] puddles) {
        //편의상 m을 세로, n을 가로로 설정
        roadMap = new int[m+1][n+1];
        roadMap[1][1] = 1;
        
        //웅덩이가 있는 곳은 roadMap을 -1로 만듬
        for(int[] puddle : puddles) {
            //좌표는 m, n 방식
            roadMap[puddle[0]][puddle[1]] = -1;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(roadMap[i][j] != -1) {
                    roadMap[i][j] += Math.max(roadMap[i][j-1], 0) + Math.max(roadMap[i-1][j], 0);
                    roadMap[i][j] %= 1000000007;
                }
            }
        }
        return roadMap[m][n];
    }
    
    
}