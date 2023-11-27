package beginner;

//인덱스 바꾸기
class Solution38 {
	    public String solution(String my_string, int num1, int num2) {
	        String answer = "";
	        String tmp = "";
	        String[] str = my_string.split("");
	        
	        tmp = str[num1];
	        str[num1] = str[num2];
	        str[num2] = tmp;
	        
	        return answer = String.join("",str);
	    }
	}