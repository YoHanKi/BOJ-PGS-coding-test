import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Map<String, Integer> map = new HashMap<>();
        
        char startChar = words[0].charAt(0);
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if(startChar != words[i].charAt(0) || map.get(words[i]) > 1) {
                System.out.println(i);
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            startChar = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}