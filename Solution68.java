package beginner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//등수 매기기
class Solution68 {
    public int[] solution(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();
        for(int i = 0 ; i < score.length; i++) {
            scoreList.add(score[i][0] + score[i][1]);
        }
        scoreList.sort(Comparator.reverseOrder());
        
        int[] answer = new int[score.length];
        for(int i = 0 ; i < score.length; i++) {
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
        }
        return answer;
    }
}