class Solution {
    
    int answer;
    int[][] Dungeons;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        backtrack(k, 0);
        return answer;
    }
    
    private void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            //피로도가 i보다 크고, 첫 방문 시
            if(!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                //i번째 던전의 피로도를 제외한 값으로 탐색
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }
}