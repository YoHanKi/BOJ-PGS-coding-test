package beginner;

//OX 퀴즈
class Solution47 {
	    public String[] solution(String[] quiz) {
	        String[] answer = new String[quiz.length];
	        
	        for(int i = 0; i < quiz.length; i++) {
	            String[] solv = quiz[i].split(" ");
	            
	            if(solv[1].equals("-")) {
	                if(Integer.parseInt(solv[0]) - Integer.parseInt(solv[2]) == Integer.parseInt(solv[4])) {
	                        answer[i] = "O";
	                } else  answer[i] = "X";
	            }
	            if(solv[1].equals("+")) {
	                if(Integer.parseInt(solv[0]) + Integer.parseInt(solv[2]) == Integer.parseInt(solv[4])) {
	                        answer[i] = "O";
	                } else  answer[i] = "X";
	            }
	        }
	        return answer;
	    }
}
	    