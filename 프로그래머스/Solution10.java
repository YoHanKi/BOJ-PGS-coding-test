package beginner;

import java.util.stream.IntStream;
import java.util.Arrays;

//짝수 홀수 갯수
class Solution10 {
	    public int[] solution(int[] numList) {
	        return IntStream
	        		.of
	        		//첫번째 배열 numList[0]
	        		((int) Arrays
	        		.stream(numList)
	        		.filter(i -> i % 2 == 0).count()
	        		//두번째 배열 numList[1]
	        		, (int) Arrays.stream(numList)
	        		.filter(i -> i % 2 == 1).count())
	        		.toArray();
	    }
	}
