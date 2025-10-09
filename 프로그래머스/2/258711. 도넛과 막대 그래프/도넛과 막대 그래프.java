import java.util.*;

class Solution {
    public static int[] solution(int[][] edges) {
        int max = 0;
        for (int[] e : edges) max = Math.max(max, Math.max(e[0], e[1]));

        List<Integer>[] g = new ArrayList[max + 1];
        int[] in = new int[max + 1];
        int[] out = new int[max + 1];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (g[u] == null) g[u] = new ArrayList<>();
            g[u].add(v);
            out[u]++;
            in[v]++;
        }

        int generated = 0;
        for (int v = 1; v <= max; v++) {
            if (generated != 0) break;
            if (out[v] >= 2 && in[v] == 0) generated = v;
        }

        int donuts = 0;
        int sticks = 0;
        int eights = 0;

        if (generated != 0 && g[generated] != null) {
            for (int start : g[generated]) {
                boolean[] seen = new boolean[max + 1];

                int cur = start;
                while (true) {
                    // 막대: 더 이상 나갈 간선이 없음
                    if (out[cur] == 0) {
                        sticks++;
                        break;
                    }
                    // 8자: 분기점(outdegree>=2)에 도달
                    if (out[cur] >= 2) {
                        eights++;
                        break;
                    }
                    // 도넛: 이 컴포넌트에서 이미 본 정점을 다시 만남
                    if (seen[cur]) {
                        donuts++;
                        break;
                    }
                    seen[cur] = true;

                    List<Integer> nexts = g[cur];
                    cur = nexts.get(0);
                }
            }
        }

        return new int[]{generated, donuts, sticks, eights};
    }
}