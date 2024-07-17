import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[] {-1};
        int min = Integer.MAX_VALUE;
        for(int i : arr) min = Math.min(min, i);
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i : arr) 
            if(i != min) answer.add(i);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}