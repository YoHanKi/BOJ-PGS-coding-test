package beginner;

import java.util.Arrays;

//자릿수 더하기
class Solution46 {
    public int solution(int n) {
        // 정수를 문자열로 변환하여 각 자리 숫자를 문자로 분리
        String[] answer = String.valueOf(n).split("");

        // 문자 배열을 정수 배열로 변환하고 합을 계산
        return Arrays.stream(answer)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}