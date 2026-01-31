import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int c = Integer.compare(o1[1], o2[1]);
            if (c != 0) return c;
            return Integer.compare(o1[0], o2[0]);
        });

        for (int[] t : targets) pq.add(t);

        int end = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int s = now[0];
            int e = now[1];

            if (s >= end) {
                answer++;
                end = e;
            }
        }

        return answer;
    }
}