package beginner;

//암호해독
class Solution35 {
    public String solution(String cipher, int code) {
        String answer = "";
        //배열로 출력
        String[] str = cipher.split("");
        //반복문으로 code 배수 첫번째 글짜는 배열이 0부터이므로, -1 부터 시작, 이후로는 i += code 로 진행
        for(int i = code - 1;i < str.length; i += code) {
        //code 배수의 글자를 answer L-value 에 적재
            answer += str[i];
        }
        return answer;
    }
}