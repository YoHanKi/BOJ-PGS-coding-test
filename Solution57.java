package beginner;

//캐릭터 좌표 구하기
class Solution57 {
	    public int[] solution(String[] keyinput, int[] board) {
	        int[] answer = new int[2];
	        int xLimit = board[0]/2;
	        int yLimit = board[1]/2;
	        
	        for(int i = 0; i < keyinput.length; i++) {
	            if(keyinput[i].equals("left")) {
	                answer[0]--;
	                if(answer[0] < -xLimit) answer[0] = -xLimit;
	            } else if (keyinput[i].equals("right")) {
	                answer[0]++;
	                if(answer[0] > xLimit) answer[0] = xLimit;
	            } else if (keyinput[i].equals("up")) {
	                answer[1]++;
	                if(answer[1] > yLimit) answer[1] = yLimit;
	            } else {
	                answer[1]--;
	                if(answer[1] < -yLimit) answer[1] = -yLimit;
	            } 
	        }        
	        return answer;
	    }
	}