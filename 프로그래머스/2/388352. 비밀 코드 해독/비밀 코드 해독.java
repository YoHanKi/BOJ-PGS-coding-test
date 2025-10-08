import java.util.*;

class Solution {
    private static int answer;
    private static int[] arr;

    public static int solution(int n, int[][] q, int[] ans) {
        return combination(n, q, ans);
    }

    public static int combination(int n, int[][] q, int[] ans) {
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        comb(n, q, ans, 0, new ArrayList<>());
        return answer;
    }

    public static void comb(int n, int[][] q, int[] ans, int cur, List<Integer> list) {
        if (list.size() == 5) {
            if (isPossible(q, ans, list)) answer++;
            return;
        }

        for (int i = cur; i < n; i++) {
            list.add(arr[i]);
            comb(n, q, ans, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static boolean isPossible(int[][] q, int[] ans, List<Integer> list) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++) {
                for (Integer integer : list) {
                    if (q[i][j] == integer) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt != ans[i]) return false;
        }
        return true;
    }
}