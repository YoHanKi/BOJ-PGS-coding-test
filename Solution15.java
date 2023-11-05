package beginner;
import java.util.Arrays;

//배열 자르기
class Solution15 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        return answer;
    }
}