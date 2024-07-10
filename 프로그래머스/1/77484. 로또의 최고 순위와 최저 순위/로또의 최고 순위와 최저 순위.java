import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int max = 0;
        int min = 7;
        int hit = 0;
        int zero = 0;

        for(int i = 0; i < lottos.length; i++) {
            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == 0) {
                    zero++;
                    hit++;
                    break;
                }
                if(lottos[i] == win_nums[j]) { 
                    hit++;
                    break;
                }
            }
        }
        
        switch(hit) {
            case 6 : min = 1; 
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
            case 5 : min = 2; 
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
            case 4 : min = 3; 
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
            case 3 : min = 4;
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
            case 2 : min = 5;
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
            default : min = 6;
                if(min+zero > 6) max = 6; 
                else max = min+zero;
                break;
        }
        
        return new int[]{min, max};
    }
}