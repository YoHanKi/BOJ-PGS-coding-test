class Solution {
    public String solution(String s, int n) {
        char[] answer = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') answer[i] = c;
            else if(c <= 'z' && c + n > (int)('z')) answer[i] = (char)(c + n - 26);
            else if(c <= 'Z' && c + n > (int)('Z')) answer[i] = (char)(c + n - 26);
            else answer[i] = (char)(c + n);
        }
        return String.valueOf(answer);
    }
}