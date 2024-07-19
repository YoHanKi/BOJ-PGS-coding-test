class Solution {
    public String solution(String s) {
        int half = s.length()/2;
        if(s.length() % 2 == 0) return s.substring(half-1, half+1);
        else return s.substring(half, half+1);
    }
}