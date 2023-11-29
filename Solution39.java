package beginner;

import java.util.Arrays;


//한번만 등장한 문자
class Solution39 {
	    public String solution(String s) {
	        String answer = "";
	        String[] str = s.split("");
	        
	        Arrays.sort(str);
	        
	        for (int i = 0; i < str.length; i++) {
	            int count = 0;
	            for (int j = 0; j < str.length; j++) {
	                if (str[i].equals(str[j])) {
	                    count++;
	                }
	            }
	            
	            if (count == 1) {
	                answer += str[i];
	            }
	        }
	        
	        return answer;
	    }
	}