package beginner;


//잘라서 배열로 저장하기
class Solution52 {
	    public String[] solution(String my_str, int n) {
	        //배열의 크기 지정(마지막 부분이 n보다 작을 경우, 버림 하기 때문에 ceil이용)
	        String[] answer = new String[(int)Math.ceil((double)my_str.length()/n)];
	        
	//substring을 사용, 반복문과 조건문으로 start와 end 부분을 지정
	        for(int i = 0; i < answer.length; i++) {
	          int start = n * i;
	          int end = 0;
	          if(start + n >= my_str.length()){
	              end = my_str.length();
	          } else {
	              end = start + n;
	          }
	          answer[i] = my_str.substring(start, end);
	      }
	        return answer;
	    }
	}