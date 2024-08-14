import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n*t*m; i++) sb.append(Integer.toString(i, n).toUpperCase());
        
        int time = 1;
        int i = 0;
        char[] ch = sb.toString().toCharArray();
        sb = new StringBuilder();
        while (i < ch.length) {
            if(time == p) {
                sb.append(ch[i++]);
                time++;
                if(sb.length() == t) break;
            } else if(time > m) {
                time = 1;
            } else {
                i++;
                time++;
            }
        }
        return sb.toString();
    }
}