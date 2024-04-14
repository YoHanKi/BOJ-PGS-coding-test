import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int point = commands[i][2] - 1;
            
            int[] tmp = new int[end - start];
            for(int j = 0; j < tmp.length; j++) {
                tmp[j] = array[j + start];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[point];
        }
        
        return answer;
    }
}