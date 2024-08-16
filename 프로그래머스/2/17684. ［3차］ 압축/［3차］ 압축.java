import java.util.*;

class Solution {
    public int[] solution(String msg) {
        char[] ch = msg.toCharArray();
        List<String> alph = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < ch.length; i++) {
            String temp = "" + ch[i];
            int saveNum = ch[i] - 'A' + 1;
            for(int j = i+1; j < ch.length; j++) {
                temp += ch[j];
                if(alph.contains(temp)) {
                    saveNum = alph.indexOf(temp) + 27;
                    i++;
                } else {
                    alph.add(temp);
                    break;
                }
            }
            list.add(saveNum);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}