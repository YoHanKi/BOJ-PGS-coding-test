import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [BOJ] 게임 개발하기 (1516) / 골드3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        //위상정렬 관련 배열 생성
        int[] inDegree = new int[N + 1];
        int[] selfBuild = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            //건물 짓는 시간
            selfBuild[i] = Integer.parseInt(st.nextToken());
            while (true) {
                //필요 건물
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp == -1) break;
                arr.get(preTemp).add(i);
                //입력이 들어왔다는 건 본인 노드를 가리키고 있다는 것이므로 ++
                inDegree[i]++;
            }
        }
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            //진입차수가 0이라면 큐에 적재
            if (inDegree[i] == 0) queue.offer(i);
        }
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : arr.get(now)) {
                inDegree[next]--;
                //필요 건물의 시간만 result 배열에 추가
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        for (int i = 1; i <= N ; i++) {
            //출력 시 본인의 시간에 필요 건물 시간을 더해 출력
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
