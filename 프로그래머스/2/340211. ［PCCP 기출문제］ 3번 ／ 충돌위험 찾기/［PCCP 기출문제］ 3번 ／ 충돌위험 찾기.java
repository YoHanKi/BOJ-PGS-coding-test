import java.util.*;

class Solution {
    public static int solution(int[][] points, int[][] routes) {
        int count = 0;
        int reach = 0;

        // 경로 먼저 계산
        Queue<int[]>[] route = bfs(points, routes);
        while (true) {
            int[][] map = new int[101][101];
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < routes.length; i++) {
                if (!route[i].isEmpty()) {
                    int[] cur = route[i].poll();
                    int x = cur[0];
                    int y = cur[1];
                    map[x][y] += 1;
                    visited.add(x + "," + y);
                } else reach++;
            }
            for (String v : visited) {
                String[] split = v.split(",");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                if (map[x][y] > 1) count++;
            }
            if (reach == routes.length) break;
            else reach = 0;
        }
        return count;
    }

    public static Queue<int[]>[] bfs(int[][] points, int[][] routes) {
        Queue<int[]>[] result = new Queue[routes.length];
        for (int i = 0; i < routes.length; i++) {
            result[i] = new LinkedList<>();
            result[i].offer(new int[]{points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]});
        }

        for (int i = 0; i < routes.length; i++) {
            int[] path = routes[i];
            Queue<int[]> q = new LinkedList<>();
            result[i] = q;

            if (path == null || path.length == 0) continue;

            int sx = points[path[0] - 1][0];
            int sy = points[path[0] - 1][1];
            int curX = sx, curY = sy;
            q.offer(new int[]{curX, curY});

            for (int j = 0; j < path.length - 1; j++) {
                int toIdx = path[j + 1] - 1;
                int destX = points[toIdx][0];
                int destY = points[toIdx][1];

                // X축 이동
                while (curX != destX) {
                    curX += (curX < destX) ? 1 : -1;
                    q.offer(new int[]{curX, curY});
                }
                // Y축 이동
                while (curY != destY) {
                    curY += (curY < destY) ? 1 : -1;
                    q.offer(new int[]{curX, curY});
                }
            }
        }
        return result;
    }
}