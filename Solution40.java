package beginner;

import java.util.stream.IntStream;

//약수 구하기
class Solution40 {
	    public int[] solution(int n) {
	        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
	    }
	}