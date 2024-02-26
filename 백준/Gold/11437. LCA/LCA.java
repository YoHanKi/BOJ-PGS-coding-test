import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [BOJ] LCA (11437) / 골드 3
 * 일반적인 LCA 알고리즘
 */
public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = calLCA(a, b);
            System.out.println(LCA);
        }
    }

    private static int calLCA(int a, int b) {
        //항상 a가 깊은 노드로 설정
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }//a가 만약 깊이가 다르다면, 부모를 찾아가며 높이를 맞춘다.
        while (depth[a] != depth[b]) {
            a = parent[a];
        }//a, b 가 서로 같아질 때 까지, 같이 부모를 타고 올라간다.
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);
        //높이
        int level = 1;
        //같은 층의 갯수
        int nowSize = 1;
        //같은 층의 갯수를 확인 하기 위한 변수
        int count = 0;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int next : tree[nowNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    parent[next] = nowNode; //LCA를 위해 부모노드 저장
                    depth[next] = level; //깊이 저장
                }
            }
            //하나의 탐색이 종료되면
            count++;
            //탐색을 마친 노드의 갯수와 Size의 갯수가 같다면 같은 높이를 모두 마친 것 이므로,
            if (count == nowSize) {
                //초기화
                count = 0;
                //그 다음 깊이 노드 갯수
                nowSize = queue.size();
                //depth를 1 증가
                level++;
            }
        }
    }
}
