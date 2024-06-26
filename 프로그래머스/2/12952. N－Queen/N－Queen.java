class Solution {
    
    int N;
    boolean[] width;
    boolean[] diagonal1;
    boolean[] diagonal2;
    
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        int answer = getNQueen(0);
        
        return answer;
    }
    
    private int getNQueen(int x) {
        int answer = 0;
        if (x == N) answer++;
        else {
            for (int i = 0; i < N; i++) {
                //해당 위치 또는 대각선상 퀸이 있는 경우 모두 스킵
                if (width[i] || diagonal1[i + x] || diagonal2[i - x + N])
                    continue;
                
                width[i] = diagonal1[i + x] = diagonal2[i - x + N] = true;
                
                answer += getNQueen(x + 1);
                
                width[i] = diagonal1[i + x] = diagonal2[i - x + N] = false;
            }
        }
        return answer;
    }
}