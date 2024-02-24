import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [BOJ] 트리 (1068) / 골드5
 */
public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    static int answer, del;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        visited = new boolean[N];
        int root = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) root = i;
            else {
                tree[i].add(tmp);
                tree[tmp].add(i);
            }
        }
        del = Integer.parseInt(br.readLine());
        if (del == root) System.out.println(0);
        else {
            DFS(root);
            System.out.println(answer);
        }
    }

    private static void DFS(int root) {
        visited[root] = true;
        int cNode = 0;
        for (int i : tree[root]) {
            if (!visited[i] && i != del) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) answer++;
    }
}
