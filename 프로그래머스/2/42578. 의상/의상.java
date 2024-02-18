import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();       
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) { 
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 조합
        }
        
        return answer-1;
    }
}