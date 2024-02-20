import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 집합의 표현 (1717) / 골드5
 */
public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        //유니온-파인드는 초기 인덱스로 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int commend = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (commend == 0) union(a, b);
            else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        //a와 b의 대표노드가 같지 않다면 a를 대표노드로 지정
        if(a != b) parent[b] = a;
    }
    //유니온 파인드의 핵심
    private static int find(int a) {
        //인덱스와 값이 일치 시 대표 노드이므로 반환
        if (a == parent[a]) return a;
        //일치하지 않을 시 재귀로 대표 노드를 find
        else return parent[a] = find(parent[a]);
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        return false;
    }
}
