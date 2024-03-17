import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] calToday = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            for(int j = 0; j < terms.length; j++) {
                String[] tmp = terms[j].split(" ");
                if(!tmp[0].equals(str[str.length-1])) continue;
                int[] ch = Arrays.stream(str[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
                int sum1 = ((calToday[0] - 2000) * 12 + calToday[1]) * 28 + calToday[2];
                int sum2 = ((ch[0] - 2000) * 12 + (ch[1] + Integer.parseInt(tmp[1]))) * 28 + (ch[2] -1);
                
                if(sum1 > sum2) list.add(i+1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}