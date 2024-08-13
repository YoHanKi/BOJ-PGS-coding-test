import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeValidPairs(str1);
        List<String> list2 = makeValidPairs(str2);
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (String s : list1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        
        for (String s : list2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        
        int intersection = 0;
        int union = 0;
        
        Set<String> allElements = new HashSet<>(map1.keySet());
        allElements.addAll(map2.keySet());
        
        for (String key : allElements) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        if (union == 0) return 65536; // 둘 다 공집합일 경우
        
        return (int) (((double) intersection / union) * 65536);
    }
    
    private List<String> makeValidPairs(String str) {
        List<String> pairs = new ArrayList<>();
        str = str.toUpperCase();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            
            if (Character.isLetter(first) && Character.isLetter(second)) {
                pairs.add("" + first + second);
            }
        }
        
        return pairs;
    }
}