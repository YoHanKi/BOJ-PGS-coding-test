import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, String> member = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) 
            member.put(enroll[i], referral[i]);
        
        for(int i = 0; i < seller.length; i++) {
            String sName = seller[i];
            int sMoney = amount[i] * 100;
            
            while(sMoney > 0 && !sName.equals("-")) {
                total.put(sName, total.getOrDefault(sName, 0) + sMoney - (sMoney / 10));
                sName = member.get(sName);
                sMoney /= 10;
            }
        }
        
        
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}