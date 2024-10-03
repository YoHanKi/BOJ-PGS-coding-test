import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(N, 1);
        for (int i = 2; i < 9; i++) {
            int repeatNum = Integer.parseInt(String.valueOf(N).repeat(i));
            map.put(repeatNum, i);
            
            //ConcurrentModificationException을 피하기 위해 Set을 생성
            Set<Integer> keys = new HashSet<>(map.keySet());
            
            for (int key1 : keys) {
                for (int key2 : keys) {
                    if (map.get(key1) + map.get(key2) == i) {
                        
                        int sum = key1 + key2;
                        if (!map.containsKey(sum) || map.get(sum) > i) {
                            map.put(sum, i);
                        }
                        
                        int sub = key1 - key2;
                        if(!map.containsKey(sub) || map.get(sub) > i) {
                            map.put(sub, i);
                        }
                        
                        int multi = key1 * key2;
                        if (!map.containsKey(multi) || map.get(multi) > i) {
                            map.put(multi, i);
                        }
                        
                        if (key2 != 0) {
                            int divide = key1 / key2;
                            if (!map.containsKey(divide) || map.get(divide) > i) {
                                map.put(divide, i);
                            }
                        }
                    }
                }
            }
            if (map.containsKey(number)) return map.get(number);
        }
        
        
        
        return -1;
    }
}