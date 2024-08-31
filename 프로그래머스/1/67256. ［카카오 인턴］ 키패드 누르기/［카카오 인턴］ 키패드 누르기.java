import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int positionL = 10; 
        int positionR = 12; 
        StringBuilder sb = new StringBuilder();
                for(int number : numbers) {
            if(number == 0) number = 11;
            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                positionL = number;
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                positionR = number;
            } else {
                int subL = getDistance(positionL, number);
                int subR = getDistance(positionR, number);
                
                if(subL == subR) {
                    if(hand.equalsIgnoreCase("right")) {
                        sb.append("R");
                        positionR = number;
                    } else {
                        sb.append("L");
                        positionL = number;
                    }
                } else if(subL < subR) {
                    sb.append("L");
                    positionL = number;
                } else {
                    sb.append("R");
                    positionR = number;
                }
            }
        }
        return sb.toString();
    }
    
    private int getDistance(int start, int target) {
        start = (start == 0) ? 11 : start;
        target = (target == 0) ? 11 : target;
        
        int startRow = (start - 1) / 3;
        int startCol = (start - 1) % 3;
        int targetRow = (target - 1) / 3;
        int targetCol = (target - 1) % 3;
        
        return Math.abs(startRow - targetRow) + Math.abs(startCol - targetCol);
    }
}