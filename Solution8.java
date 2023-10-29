package beginner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


//배열 뒤집기
class Solution8 {
	    public int[] solution(int[] numList) {
	        List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());

	        Collections.reverse(list);
	        
	        return list.stream().mapToInt(Integer::intValue).toArray();
	    }
	}