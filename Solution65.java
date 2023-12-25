package beginner;

//겹치는 선분의 길이
class Solution65 {
    public int solution(int[][] lines) {
        int answer = 0;

        int[] count = new int[201];

        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;

            for (int k = start; k < end; k++) {
                count[k] += 1;
            }
        }

        for (int value : count) {
            if (value > 1) {
                answer++;
            }
        }

        return answer;
    }
}