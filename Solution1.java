package beginner;

import java.util.*;
 
//hash맵을 가용한 최빈값
class Solution1 {
public int solution(int[] array) {
        int answer = 0;
        int maxAns = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.isEmpty() || !map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int value = map.get(array[i]);
                map.put(array[i], value + 1);
            }
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > answer) {
                answer = value;
                maxAns = key;
            } else if (value == answer) {
                answer = -1;
                maxAns = -1;
                for (int subKey : map.keySet()) {
                    int subValue = map.get(subKey);
                    if (value == subValue) {
                        map.put(key, -1);
                        break;
                    }
                }
            }
        }
        return maxAns;
    }
}