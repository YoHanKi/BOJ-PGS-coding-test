import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int max = routes[0][1];
        for(int[] route : routes){
            if(max < route[0]) {
                max = route[1];
                answer++;
            }
        }
        return answer;
    }
}