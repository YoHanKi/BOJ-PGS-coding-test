import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [BOJ] 임계 경로 (1948) / 플레티넘 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> arr = new ArrayList<>();
        ArrayList<ArrayList<dNode>> reverseArr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(s).add(new dNode(e,v));
            //역방향이므로 적재 방향이 반대여야함.
            reverseArr.get(e).add(new dNode(s,v));
            inDegree[e]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //위상정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : arr.get(now)) {
                inDegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode],result[now] + next.value );
                if (inDegree[next.targetNode] == 0) queue.offer(next.targetNode);
            }
        }
        //위상정렬 reverse
        int resultCount = 0;
        //방문한 곳은 재방문 하지 않기 위해 배열 생성
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(dNode next : reverseArr.get(now)) {
                //1분도 쉬지 않는 도로
                if(result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    if (visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCount);
    }

    private static class dNode {
        int targetNode;
        int value;
        dNode(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
