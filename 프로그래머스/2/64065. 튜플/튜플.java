import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] str = s.substring(1, s.length()-2).replace("{", "").split("},");
        
        List<String[]> list = new ArrayList<>();
        for(String string : str) {
            list.add(string.split(","));
        }
        
        list.sort((o1, o2) -> o1.length - o2.length);
        
        Set<Integer> set = new LinkedHashSet<>();
        for(String[] strings : list) {
            for(String string : strings) {
                set.add(Integer.parseInt(string));
            }
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}