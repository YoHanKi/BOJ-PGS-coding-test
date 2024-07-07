import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) map.put(t, map.getOrDefault(t, 0) + 1);
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        for(int num : list) {
            k -= num;
            answer++;
            if(k <= 0) break;
        }
        return answer;
    }
}