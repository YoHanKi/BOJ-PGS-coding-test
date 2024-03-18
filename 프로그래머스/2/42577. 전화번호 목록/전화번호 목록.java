import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        
        for(String Num : phone_book) hashmap.put(Num, 1);
        
        for(String Num : phone_book){
            for (int i = 1; i < Num.length(); i++) {
                if(hashmap.containsKey(Num.substring(0, i))) return false;
            }
        }
        return true;
    }
}