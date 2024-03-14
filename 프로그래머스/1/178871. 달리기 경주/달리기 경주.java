import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> list = new ArrayList<>(Arrays.asList(players));
        Map<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }
        
        for (String call : callings) {
            int index = indexMap.get(call); 
                Collections.swap(list, index, index - 1);
                indexMap.put(call, index - 1);
                indexMap.put(list.get(index), index);
        }
        
        return list.toArray(new String[0]);
    }
}