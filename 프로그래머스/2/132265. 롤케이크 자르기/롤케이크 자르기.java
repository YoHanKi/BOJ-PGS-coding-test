import java.util.*;

public class Solution {
    public int solution(int[] topping) {
        int n = topping.length;

        // Prefix와 Suffix 계산을 위한 Set과 배열 선언
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Set<Integer> set = new HashSet<>();

        // Prefix 배열 계산
        for (int i = 0; i < n; i++) {
            set.add(topping[i]);
            prefix[i] = set.size();
        }

        set.clear();

        // Suffix 배열 계산
        for (int i = n - 1; i >= 0; i--) {
            set.add(topping[i]);
            suffix[i] = set.size();
        }

        // Prefix와 Suffix 비교
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                result++;
            }
        }

        return result;
    }
}