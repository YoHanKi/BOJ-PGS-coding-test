import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        boolean[] check = new boolean[201];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                check[numbers[i] + numbers[j]] = true;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}