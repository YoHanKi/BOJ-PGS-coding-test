import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * [BOJ] 칵테일 (1033) / 골드 2
 */
public class Main {
    static ArrayList<Node>[] list; //인접리스트로 DFS 구현
    static boolean[] visited; //DFS를 위한 방문 여부 배열
    static long lcm; //최소공배수
    static long[] D; //최종 비율 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        //초기화(안할 시 NPE 발생)
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            //양방향 노드 생성을 위해 a, b로 처리 한다.
            list[a].add(new Node(b,p,q));
            //반대의 경우는 비율이 반대로 적용 되야 한다.
            list[b].add(new Node(a,q,p));
            //최소공배수 공식
            lcm *= (p * q / gcd(p,q));
        }
        //기준이 될 D[0] 초기화
        D[0] = lcm;
        //0노드부터 DFS 탐색
        DFS(0);

        long mgcd = D[0];
        //모든 비율에 대한 최대 공약수 계산
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        //최종비율에서 최대 공약수로 나누어 최소 비율로 출력
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }

    }

    private static void DFS(int i) {
        //방문 배열 체크
        visited[i] = true;
        //list 모든 노드를 방문하여
        for(Node node : list[i]) {
            int next = node.b;
            if(!visited[next]) {
                //최종비율배열은 초기 D[0]을 기준으로 비율로 나눈다.
                D[next] = D[i] * node.q / node.p;
                DFS(next);
            }
        }
    }

    private static long gcd(long a, long b) { //유클리드 호제법
        long remain;
        long tmp;
        if(a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while (true) {
            remain = b % a;
            if (remain != 0) {
                b = a;
                a = remain;
            } else break;
        }
        return a;
    }

    static class Node { //3개의 필드를 가진 객체를 탐색하기 위해 추가
        public int b;
        public int p;
        public int q;
        Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
}
