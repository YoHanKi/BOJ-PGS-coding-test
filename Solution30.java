package beginner;

//배열 원소의 길이
class Solution30 {
	    public int[] solution(String[] strlist) {
	        int[] answer = new int[strlist.length];

	        for(int i=0 ; i < strlist.length; i++) {
	            answer[i] = strlist[i].length();
	        }
	        return answer;
	    }
	}