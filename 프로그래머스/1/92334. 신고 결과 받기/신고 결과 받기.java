import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[][] reports = new int[id_list.length][id_list.length];
        Map<String, Integer> user = new HashMap<>();
        int[] counts = new int[id_list.length];
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) 
        user.put(id_list[i], i);
        
        for(String s : report) {
            String[] tmp = s.split(" ");
            int tmp0 = user.get(tmp[0]); 
            int tmp1 = user.get(tmp[1]);
            if(reports[tmp0][tmp1] == 1) continue;
            reports[tmp0][tmp1] = 1;
            counts[tmp1]++;
        }
        
        for(int i = 0; i < id_list.length; i++) {
            if (counts[i] >= k) {
                for(int j = 0; j < id_list.length; j++) {
                    if(reports[j][i] > 0) answer[j]++;
                }
            } 
        }     
        return answer;
    }
}