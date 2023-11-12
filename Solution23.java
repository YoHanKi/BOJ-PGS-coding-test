package beginner;

import java.util.Arrays;

//주사위의 갯수
class Solution23 {
    public int solution(int[] box, int n) {
        return Arrays.stream(box, 0, 4) // 처음 3개 요소를 가져오기
                .map(element -> element / n) // 요소를 n으로 나누기
                .reduce(1, (x, y) -> x * y); // 결과를 곱하기
    }
}