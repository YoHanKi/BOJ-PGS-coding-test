import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> user = new HashMap<>();
        int[] counts = new int[id_list.length];
        int[][] reports = new int[id_list.length][id_list.length];
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) user.put(id_list[i], i);
        
        for(int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            if(reports[user.get(tmp[0])][user.get(tmp[1])] == 1) continue;
            reports[user.get(tmp[0])][user.get(tmp[1])] = 1;
            counts[user.get(tmp[1])]++;
        }
        
        for(int i = 0; i < id_list.length; i++) {
            if (counts[i] >= k) {
                for(int j = 0; j < id_list.length; j++) {
                    if(reports[j][i] > 0) {
                        answer[j]++;
                    }
                }
            } 
        }     
        return answer;
    }
}