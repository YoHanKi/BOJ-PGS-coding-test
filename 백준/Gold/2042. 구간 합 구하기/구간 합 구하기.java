import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 구간 합 구하기 (2042) / 골드 1
 */
public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        //배열 길이를 구하는 방법
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafNode = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = leafNode + 1; i <= leafNode + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) changeVal(leafNode + s, e);
            else if (a == 2) {
                s = leafNode + s;
                e = leafNode + e;
                System.out.println(getSum(s, (int)e));
            } else return;
        }
    }

    //트리 구간 합
    private static long getSum(int s, int e) {
        long partSum = 0;
        //교차하는 순간 종료
        while (s <= e) {
            //리프 노드부터 탐색
            if (s % 2 == 1) {
                //우측 노드이면 저장 후 +1
                partSum = partSum + tree[s];
                s++;
            }
            if (e % 2 == 0) {
                //좌측 노드이면 저장 후 -1
                partSum = partSum + tree[e];
                e--;
            }
            //부모 노드로 이동
            s = s / 2;
            e = e / 2;
        }
        return partSum;
    }

    private static void changeVal(int i, long v) {
        //현재 노드와의 차이를 구함
        long diff = v - tree[i];
        while (i > 0) {
            //차이값 만큼 부모 노드 업데이트
            tree[i] += diff;
            i = i / 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
