import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //인접 리스트를 사용하여 구현한다.
    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            //만약 방문하지 않았다면 count 증가
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    //깊이 우선 탐색은 스택 또는 재귀함수로 구현할 수 있다.
    private static void DFS(int v) {
        //방문했다면 return
        if(visited[v]) return;
        //방문하지 않았다면 true로 변경
        visited[v] = true;
        //노드가 연결된 엣지를 탐색하며 방문하지 않은 곳에 재귀 호출
        for (int i : arr[v]) {
            if(visited[i] == false) DFS(i);
        }
    }
}
