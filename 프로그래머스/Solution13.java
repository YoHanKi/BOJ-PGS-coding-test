package beginner;

//특정문자제거
class Solution13 {
    public String solution(String my_string, String letter) {
        String answer = my_string.replace(letter,"");
        return answer;
    }
}
