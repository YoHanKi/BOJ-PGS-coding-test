import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [BOJ] 최솟값 (10868) / 골드 1
 */
public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafStart = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        //기본값 0일 시, 항상 0이 작은 값 이므로 MAX_VALUE 초기화 
        Arrays.fill(tree, Long.MAX_VALUE);
        for (int i = leafStart + 1; i <= leafStart + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start += leafStart;
            end += leafStart;
            System.out.println(getMin(start, end));
        }
        br.close();
    }

    private static long getMin(int s, int e) {
        long Min = Long.MAX_VALUE;
        while(s <= e) {
            if (s % 2 == 1) {
                Min = Math.min(Min, tree[s]);
                s++;
            }
            if (e % 2 == 0) {
                Min = Math.min(Min, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return Min;
    }

    private static void setTree(int i) {
        //배열 가장 끝부터, 부모 노드와 비교하여 최신화
        while (i != 1) {
            if (tree[i / 2] > tree[i]) tree[i / 2] = tree[i];
            i--;
        }
    }
}
