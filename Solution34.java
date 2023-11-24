package beginner;

//369게임
class Solution34 {
	    public int solution(int order) {
	        int answer = 0;
	        String Order = Integer.toString(order);
	    return Order.replaceAll("[^3,6,9]","").length();
	    }
	}