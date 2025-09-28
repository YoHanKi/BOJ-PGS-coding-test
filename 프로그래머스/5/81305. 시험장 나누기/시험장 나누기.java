import java.util.*;

class Solution {
    public int solution(int k, int[] num, int[][] links) {
        int total = 0;
        for (int n : num) {
            total += n;
        }
        int able = k - 1;
        if (able == 0) return total;
        
        final int n = num.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            left[i] = links[i][0];
            right[i] = links[i][1];
            if (left[i] != -1) parent[left[i]] = i;
            if (right[i] != -1) parent[right[i]] = i;
        }

        int root = -1;
        for (int i = 0; i < n; i++) if (parent[i] == -1) { root = i; break; }

        long lo = 0, hi = 0;
        int maxW = 0;
        for (int w : num) { hi += w; maxW = Math.max(maxW, w); }
        lo = maxW;

        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (canPartition(num, left, right, root, k, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }
    
    private boolean canPartition(int[] num, int[] left, int[] right, int root, int k, long cap) {
        final int n = num.length;
        long[] sum = new long[n];   // 위로 올릴 잔여합
        int[] cuts = new int[n];    // 이 서브트리에서 이미 확정된 그룹 수

        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{root, 0}); // 0=미방문, 1=처리
        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int u = cur[0], state = cur[1];
            if (state == 0) {
                st.push(new int[]{u, 1});
                if (left[u]  != -1) st.push(new int[]{left[u], 0});
                if (right[u] != -1) st.push(new int[]{right[u], 0});
            } else {
                long w = num[u];
                if (w > cap) return false; // 단일 노드도 못 담으면 불가능

                long sL = 0, sR = 0; int c = 0;
                if (left[u]  != -1) { sL = sum[left[u]];  c += cuts[left[u]]; }
                if (right[u] != -1) { sR = sum[right[u]]; c += cuts[right[u]]; }

                if (sL + sR + w <= cap) {
                    // 셋 다 합쳐서 위로 올림
                    sum[u] = sL + sR + w;
                    cuts[u] = c;
                } else {
                    boolean fitL = (w + sL) <= cap;
                    boolean fitR = (w + sR) <= cap;

                    if (fitL && fitR) {
                        long keep = Math.min(sL, sR);
                        sum[u] = w + keep;
                        cuts[u] = c + 1;
                    } else if (fitL) {
                        // L만 붙일 수 있음, R는 자름
                        sum[u] = w + sL;
                        cuts[u] = c + (right[u] != -1 ? 1 : 0);
                    } else if (fitR) {
                        // R만 붙일 수 있음, L는 자름
                        sum[u] = w + sR;
                        cuts[u] = c + (left[u] != -1 ? 1 : 0);
                    } else {
                        // 둘 다 못 붙임 -> 둘 다 자르고 부모는 단독으로 위로 올림
                        sum[u] = w;
                        int add = 0;
                        if (left[u]  != -1) add++;
                        if (right[u] != -1) add++;
                        cuts[u] = c + add;
                    }
                }
            }
        }

        int groups = cuts[root] + 1; // 루트에 남은 잔여합까지 포함
        return groups <= k;
    }
}