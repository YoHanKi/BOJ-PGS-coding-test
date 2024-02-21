import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [BOJ] 줄 세우기 (2252) / 골드 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        //진입차수 배열
        int[] inDegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //방향이 있는 그래프이므로 단방향 입력
            arr.get(a).add(b);
            //a -> b 이므로 b의 진입차수 증가
            inDegree[b]++;
        }
        //위상 정렬 수행 큐
        Queue<Integer> queue = new LinkedList<>();
        //0인 배열이 다수 존재할 수 있으므로 전체배열의 0을 queue에 적재
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }
        //큐가 빌때까지
        while (!queue.isEmpty()) {
            int now = queue.poll();
            //큐에서 빼낸 데이터를 출력
            System.out.print(now + " ");
            for (int next : arr.get(now)) {
                //now 노드에 연결된 노드의 진입차수를 감소
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    //감소하여 0이 되었다면 큐에 적재
                    queue.offer(next);
                }
            }
        }
    }
}
