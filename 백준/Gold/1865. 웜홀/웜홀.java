import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[] dist = new int[N + 1];
            List<List<String[]>> edges = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    edges.get(S).add(new String[]{String.valueOf(S), String.valueOf(E), String.valueOf(T)});
                    edges.get(E).add(new String[]{String.valueOf(E), String.valueOf(S), String.valueOf(T)});
                } else {
                    edges.get(S).add(new String[]{String.valueOf(S), String.valueOf(E), String.valueOf(-T)});
                }
            }

            boolean isCycle = false;
            for (int i = 1; i <= N; i++) {
                dist[i] = 0;
            }
            dist[1] = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (String[] edge : edges.get(j)) {
                        int start = Integer.parseInt(edge[0]);
                        int end = Integer.parseInt(edge[1]);
                        int time = Integer.parseInt(edge[2]);

                        if (dist[start] != Integer.MAX_VALUE && dist[end] > dist[start] + time) {
                            dist[end] = dist[start] + time;
                            if (i == N) {
                                isCycle = true;
                            }
                        }
                    }
                }
            }
            System.out.println(isCycle ? "YES" : "NO");
        }
    }
}
