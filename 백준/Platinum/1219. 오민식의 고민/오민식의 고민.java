import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [BOJ] 오민신의 고민 (1219) / 플레티넘5
 */
public class Main {
    static long[] distance, cityMoney;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        distance = new long[N];
        cityMoney = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[sCity] = cityMoney[sCity];
        //양수사이클
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                //출발노드가 방문하지 않은 배열이라면 skip
                if (distance[start] == Long.MIN_VALUE) continue;
                //출발노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                else if (distance[start] == Long.MAX_VALUE)
                    distance[end] = Long.MAX_VALUE;
                //돈을 벌 수 있는 새로운 경로가 발견되면 업데이트
                else if ( distance[end] < distance[start] + cityMoney[end] - price) {
                    distance[end] = distance[start] + cityMoney[end] - price;
                    //N-1 반복 이후 업데이트 되는 종료 노드는 양수 사이클 연결 노드로 변경
                    if (i >= N -1) distance[end] = Long.MAX_VALUE;
                }
            }
        }
        if (distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if (distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }

    private static class Edge {
        int start;
        int end;
        int price;
        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
