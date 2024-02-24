import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [BOJ] 다리 만들기2 / 골드 1
 * 솔직히 전혀 모르겠어서 작성하고 공부하였다..
 * 
 */
public class Main {
    // 방향 탐색을 위한 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] parent; // 부모 노드를 저장하기 위한 배열
    static int[][] map; // 지도 정보를 저장하는 2차원 배열
    static boolean[][] visited; // 방문 여부를 체크하는 2차원 배열
    static ArrayList<ArrayList<int[]>> sumList; // 각 섬의 좌표를 저장하는 리스트
    static ArrayList<int[]> mList; // BFS 탐색 중 현재 섬의 좌표를 임시로 저장하는 리스트
    static PriorityQueue<Edge> priorityQueue; // 다리 정보를 우선순위 큐로 관리하여 가장 짧은 다리부터 처리
    static int N, M, sNum; // 세로 길이(N), 가로 길이(M), 섬의 번호(sNum)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 길이 입력
        M = Integer.parseInt(st.nextToken()); // 가로 길이 입력
        map = new int[N][M]; // 지도 크기 할당
        visited = new boolean[N][M]; // 방문 배열 크기 할당
        for (int i = 0; i < N; i++) { // 지도 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sNum = 1; // 섬의 번호 초기화
        sumList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) { // 섬의 일부이며 방문하지 않은 경우
                    BFS(i, j); // BFS를 통해 섬 탐색 및 라벨링
                    sNum++; // 다음 섬 번호로 업데이트
                    sumList.add(mList); // 현재 탐색된 섬의 좌표 리스트 추가
                }
            }
        }
        priorityQueue = new PriorityQueue<>(); // 다리 정보를 저장할 우선순위 큐 초기화
        // 모든 섬의 좌표를 순회하며 다리를 만들 수 있는지 확인
        for (int i = 0; i < sumList.size(); i++) {
            ArrayList<int[]> now = sumList.get(i);
            for (int j = 0; j < now.size(); j++) {
                int x = now.get(j)[0];
                int y = now.get(j)[1];
                int nowS = map[x][y]; // 현재 섬의 번호
                // 4방향으로 다리를 놓을 수 있는지 탐색
                for (int d = 0; d < 4; d++) {
                    int tmpX = dx[d];
                    int tmpY = dy[d];
                    int bridge = 0; // 다리 길이
                    while (x + tmpX >= 0 && x + tmpX < N && y + tmpY >= 0 && y + tmpY < M) {
                        if (map[x + tmpX][y + tmpY] == nowS) break; // 같은 섬을 만나면 중단
                        else if (map[x + tmpX][y + tmpY] != 0) { // 다른 섬을 만나면
                            if (bridge > 1) priorityQueue.offer(new Edge(nowS, map[x + tmpX][y + tmpY], bridge)); // 다리 길이가 2 이상이면 큐에 추가
                            break;
                        } else bridge++; // 바다를 만나면 다리 길이 증가
                        // 다음 칸으로 이동
                        if (tmpX < 0) tmpX--;
                        else if (tmpX > 0) tmpX++;
                        else if (tmpY < 0) tmpY--;
                        else if (tmpY > 0) tmpY++;
                    }
                }
            }
        }
        parent = new int[sNum]; // 부모 배열 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // 초기 부모는 자기 자신
        }
        int useEdge = 0; // 사용된 다리의 수
        int result = 0; // 다리 길이의 총합
        while (!priorityQueue.isEmpty()) {
            Edge now = priorityQueue.poll(); // 가장 짧은 다리 정보 가져오기
            if (find(now.s) != find(now.e)) { // 두 섬이 연결되지 않은 경우
                union(now.s, now.e); // 두 섬을 연결
                result += now.v; // 다리 길이 추가
                useEdge++; // 사용된 다리 수 증가
            }
        }
        if (useEdge == sNum - 2) System.out.println(result); // 모든 섬이 연결된 경우 결과 출력
        else System.out.println(-1); // 연결할 수 없는 경우 -1 출력
    }

    private static void union(int a, int b) {
        a = find(a); // a의 루트 찾기
        b = find(b); // b의 루트 찾기
        if (a != b) parent[b] = a; // 루트가 다르면 연결
    }

    private static int find(int a) {
        if (parent[a] == a) return a; // 루트를 찾은 경우
        else return parent[a] = find(parent[a]); // 루트가 아니면 루트를 찾을 때까지 재귀 호출
    }

    // BFS로 섬 구분하기
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>();
        int[] start = {i, j};
        queue.offer(start); // 시작 좌표 큐에 추가
        mList.add(start); // 시작 좌표 리스트에 추가
        visited[i][j] = true; // 방문 표시
        map[i][j] = sNum; // 섬 번호 할당
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 좌표 가져오기
            int x = now[0];
            int y = now[1];
            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int tmpX = dx[d];
                int tmpY = dy[d];
                // 배열 범위를 벗어나지 않는 선에서 탐색
                if (x + tmpX >= 0 && x + tmpX < N && y + tmpY >= 0 && y + tmpY < M) {
                    // 방문하지 않았고, 바다가 아닌 경우 같은 섬으로 처리
                    if (!visited[x + tmpX][y + tmpY] && map[x + tmpX][y + tmpY] != 0) {
                        map[x + tmpX][y + tmpY] = sNum; // 섬 번호 할당
                        visited[x + tmpX][y + tmpY] = true; // 방문 표시
                        int[] temp = {x + tmpX, y + tmpY};
                        mList.add(temp); // 리스트에 좌표 추가
                        queue.add(temp); // 큐에 좌표 추가
                    }
                }
            }
        }
    }

    // 다리 정보를 저장하기 위한 클래스
    private static class Edge implements Comparable<Edge> {
        int s, e, v; // 시작 섬 번호, 끝 섬 번호, 다리 길이
        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
        // 우선순위 큐에서 다리 길이에 따라 정렬하기 위한 메소드
        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}