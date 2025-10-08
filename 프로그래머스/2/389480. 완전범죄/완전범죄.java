import java.util.*;

class Solution {
    public static int solution(int[][] info, int n, int m) {
        boolean[][][] visited = new boolean[info.length + 1][n + 1][m + 1];

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0}); // index, first, second
        visited[0][0][0] = true;

        int minCount = Integer.MAX_VALUE;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int index = current[0];
            int first = current[1];
            int second = current[2];

            if (index == info.length) {
                if (first < n && second < m) {
                    minCount = Math.min(minCount, first);
                }
                continue;
            }

            int newFirst = first + info[index][0];
            if (newFirst <= n && second <= m && !visited[index + 1][newFirst][second]) {
                deque.add(new int[]{index + 1, newFirst, second});
                visited[index + 1][newFirst][second] = true;
            }

            int newSecond = second + info[index][1];
            if (first <= n && newSecond <= m && !visited[index + 1][first][newSecond]) {
                deque.add(new int[]{index + 1, first, newSecond});
                visited[index + 1][first][newSecond] = true;
            }
        }

        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}