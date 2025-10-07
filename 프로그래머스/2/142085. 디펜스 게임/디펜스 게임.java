import java.util.*;

class Solution {
    public static int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int totalEnemies = 0;

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            totalEnemies += enemy[i];

            if (totalEnemies > n) {
                if (k > 0) {
                    totalEnemies -= pq.poll(); // 가장 큰 적의 수를 제거
                    k--;
                } else {
                    return i; // 방어 실패
                }
            }
        }

        return enemy.length; // 모든 적을 방어
    }
}