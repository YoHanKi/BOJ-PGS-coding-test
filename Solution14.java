package beginner;
import java.util.stream.IntStream;

//짝수의 합
class Solution14 {
	    public int solution(int n) {
	            return IntStream.rangeClosed(0, n)
	            .filter(i -> i % 2 == 0)
	            .sum();
	    }
	}