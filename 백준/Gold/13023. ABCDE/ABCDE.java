import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        goal = false;

        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if(goal) break;
        }
        if (goal) System.out.println("1");
        else System.out.println("0");
    }
    //깊이 만큼
    private static void DFS(int now, int depth) {
        //ABCDE 즉 5번이 연결 되면 완료 되기 때문에 depth로 카운트 한다.
        if(depth == 5 || goal) {
            goal = true;
            return;
        }

        visited[now] = true;
        for(int i : arr[now]) {
            //방문한 배열이 아니 라면, DFS의 다음 엣지 노드로 재귀 호출 한다.
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        //맞지 않는 탐색을 하였을 때, 빠져나오는 경우 false로 변경 해줘야 한다.
        visited[now] = false;
    }
}