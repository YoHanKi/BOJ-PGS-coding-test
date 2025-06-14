import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
            parents[i] = -1;
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = arr[a];
            ArrayList<Integer> list2 = arr[b];

            list.add(b);
            list2.add(a);
        }
        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void DFS(int node) {
        for (int next : arr[node]) {
            if (parents[next] == -1) {
                parents[next] = node;
                DFS(next);
            }
        }
    }
}
