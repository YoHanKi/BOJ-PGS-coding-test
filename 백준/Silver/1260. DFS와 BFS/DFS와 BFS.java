import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드 수
        int M = Integer.parseInt(st.nextToken()); //엣지 수
        int V = Integer.parseInt(st.nextToken()); //시작점
        arr = new ArrayList[N+1];
        //객체 생성
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arr[node1].add(node2);
            arr[node2].add(node1);
        }
        //번호가 작은 노드부터 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println();
        br.close();
    }
    private static void DFS(int Node) {
        //방문 순서를 출력해야 하므로 처음에 출력
        System.out.print(Node + " ");
        //방문 노드는 표시
        visited[Node] = true;
        //재귀로 stack이 빌때까지 반복
        for(int i : arr[Node]) {
            if(!visited[i]) DFS(i);
        }
    }
    private static void BFS(int Node) {
        //BFS는 큐로 구현
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        //방문 노드는 표시
        visited[Node] = true;
        //큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode + " ");
            
            for(int i : arr[nowNode]) {
                if(!visited[i]) {
                    //큐에 방문한 노드는 체크
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}