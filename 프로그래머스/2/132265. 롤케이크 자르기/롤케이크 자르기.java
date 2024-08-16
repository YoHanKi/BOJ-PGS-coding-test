import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            int number = topping[i];
            set.add(number);
            map.put(number, map.get(number) - 1);
            
            if(map.get(number) == 0) map.remove(number);
            
            if(set.size() == map.size()) answer++;
        }
        
        return answer;
    }
}