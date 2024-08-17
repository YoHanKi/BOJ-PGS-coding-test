import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> visited = new HashSet<>();
        
        int x = 5;
        int y = 5;
        for(char ch : dirs.toCharArray()) {
            int nowX = x + dx[dirNum(ch)];
            int nowY = y + dy[dirNum(ch)];
            if(nowX < 0 || nowX > 10 || nowY < 0 || nowY > 10) {
                continue;
            }
            String path1 = x + "" + y + "" + nowX + "" + nowY;
            String path2 = nowX + "" + nowY + "" + x + "" + y;
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            x = nowX;
            y = nowY;
        }
        return answer;
    }
    
    private int dirNum(char ch) {
        switch(ch) {
            case 'U' : return 0;
            case 'D' : return 1;
            case 'R' : return 2;
            case 'L' : return 3;
        }
        return 0;
    }
}