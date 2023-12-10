package beginner;

import java.util.Arrays;

//문자열 정렬하기(2)
class Solution51 {
    public String solution(String my_string) {
        String answer = "";
        String[] arry = my_string.toLowerCase().split("");

        Arrays.sort(arry);

        for(int i = 0; i<arry.length; i++){
            answer += arry[i];   
        }        
        return answer;
    }
}