package beginner;

//대문자와 소문자
class Solution36 {
    public String solution(String my_string) {
        String answer="";
        for(int i=0; i<my_string.length(); i++) {
            //isUpperCase = 대문자인지 확인하는 메서드
                if(Character.isUpperCase(my_string.charAt(i))) {            
            //toLower과 toUpper = 소문자 또는 대문자로 바꿔주는 메서드
                    answer+=String.valueOf(my_string.charAt(i)).toLowerCase();  
                }else {                                                         
                    answer+=String.valueOf(my_string.charAt(i)).toUpperCase();  
                }
            }
        return answer;
    }
}