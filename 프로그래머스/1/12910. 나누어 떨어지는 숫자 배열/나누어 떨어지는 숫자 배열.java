import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        if(divisor == 1) {
            Arrays.sort(arr);
            return arr;
        }
        List<Integer> answer = new ArrayList<>();
        
        for(int num : arr) {
            if(num % divisor == 0) answer.add(num);
        }
        if(answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}