import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [BOJ] 타임머신 (11657) / 골드 4
 */
public class Main {
    static long[] distance;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //엣지리스트이므로 엣지기준 배열 생성
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        //벨만-포드 알고리즘(문제는 1번 도시이므로 1번도시 초기화)
        distance[1] = 0;
        //N개보다 한개 적은 수 반복
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //더 작은 최단 거리가 있으면 업데이트
                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        //음수 사이클 확인
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            //벨만 포드와 동일하나, 업데이트가 있다는건 음수 사이클이 존재한다는 뜻
            if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(distance[i]);
            }
        } else System.out.println("-1");
    }

    private static class Edge {
        int start, end, time;
        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
