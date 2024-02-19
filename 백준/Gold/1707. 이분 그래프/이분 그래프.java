import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [BOJ] 이분 그래프(1707) / 골드4
 */
public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                arr[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                arr[A].add(B);
                arr[B].add(A);
            }
            for (int j = 1; j <= V; j++) {
                //모든 그래프가 연결되어있다는 보장이 없으므로 전체 탐색
                if(isEven) DFS(j);
                else break;
            }
            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    //깊이 우선 탐색
    private static void DFS(int i) {
        visited[i] = true;
        for (int j : arr[i]) {
            if(!visited[j]) {
                //0 또는 1 로 표기
                check[j] = (check[i]+1) % 2;
                DFS(j);
            } else if (check[i] == check[j]) {
                //같다면 사이클이 생긴것이므로 false
                isEven = false;
            }
        }
    }
}
