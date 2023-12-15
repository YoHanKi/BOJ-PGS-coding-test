package beginner;

import java.util.Arrays;

//머쓱이보다 키 큰 사람
class Solution55 {
    public int solution(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(num -> num > height)
                .count();
    }
}