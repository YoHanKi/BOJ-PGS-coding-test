class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toLowerCase().toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            if(i == 0) {
                if(Character.isAlphabetic(chars[i])) answer += Character.toUpperCase(chars[i]);
                else answer += chars[i];
                continue;
            }
            if(chars[i-1] == ' ') {
                if(Character.isAlphabetic(chars[i])) answer += Character.toUpperCase(chars[i]);
                else answer += chars[i];
            }else answer += chars[i];
        }
        
        return answer;
    }
}