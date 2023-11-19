package beginner;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//소인수 분해
class Solution29 {
    public int[] solution(int n) {
        List<Integer> factors = new ArrayList<>();

        // 2부터 시작해서 n을 소인수로 나누기
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // 중복이 이미 제거된 리스트를 배열로 변환
        int[] result = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            result[i] = factors.get(i);
        }
        int[] answer = Arrays.stream(result).distinct().toArray();
        return answer;
    }
}