import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> spelMap = getSpelMap();
        
        checkSpelIndex(spelMap, keymap);
        
        List<Integer> answerList = new ArrayList<>();
        for (String target : targets) {
            int result = 0;
            for (char targetChar : target.toCharArray()) {
                int index = spelMap.get(targetChar);
                if (index != Integer.MAX_VALUE) result += index;
                else {
                    result = 0;
                    break;
                }
            }
            answerList.add(result == 0 ? -1 : result);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public Map<Character, Integer> getSpelMap() {
        Map<Character, Integer> spelMap = new HashMap<>();
        for (int s = 'A'; s <= 'Z'; s++) {
            spelMap.put((char) s, Integer.MAX_VALUE);
        }
        return spelMap;
    }
    
    public void checkSpelIndex(Map<Character, Integer> spelMap, String[] keymap) {
        for (int i = 0; i < keymap.length; i++) {
            String keyboard = keymap[i];
            char[] key = keyboard.toCharArray();
            for (int j = 0; j < key.length; j++) {
                spelMap.put(key[j], Math.min(spelMap.get(key[j]), j + 1));
            }
        }
    }
}