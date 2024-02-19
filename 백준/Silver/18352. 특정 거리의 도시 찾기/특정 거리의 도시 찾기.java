import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [BOJ] 특정 거리의 도시 찾기 (18352) / 실버2
 */

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        //배열 초기화
        arr = new ArrayList[N+1];
        visited = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
        }
        //BFS 탐색
        BFS(X);
        //정답 배열 생성 및 저장
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if(visited[i] == K) answer.add(i);
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }

    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : arr[now]) {
                if (visited[i] == -1) {
                    //거리를 측정 해야 하므로, 현재 거리에 +1
                    visited[i] = visited[now]+1;
                    queue.add(i);
                }
            }
        }
    }
}
