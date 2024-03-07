import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static Map<Integer, Integer> range;

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        visited = new boolean[n][m];
        range = new HashMap<>();
        int answer = 0;

        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    BFS(i, j, land, count);
                    count++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            Set<Integer> uniqueOilPockets = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(land[j][i] > 0) uniqueOilPockets.add(land[j][i]);
            }

            int sum = uniqueOilPockets.stream().mapToInt(id -> range.getOrDefault(id, 0)).sum();
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public void BFS(int x, int y, int[][] land, int count) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        land[x][y] = count;
        queue.offer(new int[]{x, y});
        int oilPocketSize = 1; // 시작 지점을 포함하여 크기 1로 초기화

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextX = now[0] + dx[d];
                int nextY = now[1] + dy[d];
                if(nextX >= 0 && nextX < land.length && nextY >= 0 && nextY < land[0].length) {
                    if(!visited[nextX][nextY] && land[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        land[nextX][nextY] = count; // 석유 덩어리의 번호 할당
                        queue.offer(new int[]{nextX, nextY});
                        oilPocketSize++; // 석유 덩어리 크기 증가
                    }
                }
            }
        }

        range.put(count, oilPocketSize); // 석유 덩어리 크기 정보 업데이트
    }
}