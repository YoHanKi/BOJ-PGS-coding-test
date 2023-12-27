package beginner;

import java.util.Arrays;

//특이한 정렬
class Solution67 {
    public int[] solution(int[] numlist, int n) {
        Integer[] boxedNumlist = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedNumlist, (a, b) -> {
            int distanceA = Math.abs(a - n);
            int distanceB = Math.abs(b - n);

            // 거리가 같다면 더 큰 수가 앞에 오도록 정렬
            if (distanceA == distanceB) {
                return Integer.compare(b, a);
            }

            // 거리가 다르다면 가까운 거리를 기준으로 정렬
            return Integer.compare(distanceA, distanceB);
        });

        // Integer 배열을 다시 int 배열로 변환
        return Arrays.stream(boxedNumlist).mapToInt(Integer::intValue).toArray();
    }
}