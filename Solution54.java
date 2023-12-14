package beginner;

import java.util.Arrays;

//중복된 숫자 개수
class Solution54 {
    public int solution(int[] array, int n) {
        return (int)Arrays.stream(array)
                .filter(num -> num == n)
                .count();
    }
}