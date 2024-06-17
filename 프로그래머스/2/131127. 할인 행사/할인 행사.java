import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) 
            wantMap.put(want[i], number[i]);
        
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> discount10d = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if(wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }
            
            if (discount10d.equals(wantMap))
                answer++;
        }
        
        return answer;
    }
}