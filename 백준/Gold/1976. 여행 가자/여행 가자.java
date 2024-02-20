import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 여행가자 (1976) / 골드4
 */
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] city = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] plan = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        //인접행렬에서 도시가 연결되어 있으면 유니온 실행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(city[i][j] == 1) union(i, j);
            }
        }
        //여행 계획[1]이 계획[2]의 find 연산과 같지 않다면 연결되지 않았으므로 NO
        int index = find(plan[1]);
        for (int i = 2; i < plan.length; i++) {
            if (index != find(plan[i])) {
                System.out.println("NO");
                return;
            }
        }
        //모두 통과했다면 연결되어있는 것 이므로 YES
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
