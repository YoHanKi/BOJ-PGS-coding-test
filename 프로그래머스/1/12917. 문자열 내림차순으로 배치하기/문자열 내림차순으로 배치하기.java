import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] c = new Character[s.length()];
        
        for(int i = 0; i < c.length; i++) c[i] = s.charAt(i);
        Arrays.sort(c, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(Character ch : c) sb.append(ch);
        return sb.toString();
    }
}