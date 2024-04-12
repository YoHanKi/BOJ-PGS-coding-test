import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("(?<score>[0-9]+)(?<times>[SDT])(?<option>[*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        int answer = 0;
        int tmp = 0;
        
        while(matcher.find()) {
            if(matcher.group("option").equals("*")) answer += (tmp * 2) - tmp;
            tmp = 0;
            tmp = (int) Math.pow(Integer.parseInt(matcher.group("score")),findTimes(matcher.group("times")));
            tmp = tmp * findOption(matcher.group("option"));
            
            answer += tmp;
        }
        
        return answer;
    }
    
    public int findTimes(String s) {
        switch(s) {
            case "S" : return 1;
            case "D" : return 2;
            case "T" : return 3;
        }
        return 0;
    }
    
    public int findOption(String s) {
        switch(s) {
            case "*" : return 2;
            case "#" : return -1;
            default : return 1;
        }
    }
}