import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> point = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            String n = name[i];
            int y = yearning[i];
            point.put(n, y);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (String p : photo[i]) {
                Integer po = point.get(p);
                if (po != null) answer[i] += po;
            }
        } 
        return answer;
    }
}