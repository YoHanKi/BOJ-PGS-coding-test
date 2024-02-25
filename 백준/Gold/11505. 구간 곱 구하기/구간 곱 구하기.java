import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [BOJ] 구간 곱 구하기 (11505) / 골드 1
 */
public class Main {
    static long[] tree;
    static int MOD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafStart = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        MOD = 1000000007;
        Arrays.fill(tree, 1);
        for (int i = leafStart + 1; i <= leafStart + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) changeVal(leafStart + s, e);
            else if (a == 2) {
                s = leafStart + s;
                e = leafStart + e;
                System.out.println(getMul(s, (int)e));
            } else return;
        }
        br.close();
    }

    private static long getMul(int s, int e) {
        long Mul = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                Mul = Mul * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0) {
                Mul = Mul * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return Mul;
    }

    private static void changeVal(int i, long v) {
        tree[i] = v;
        while (i > 1) {
            i /= 2;
            tree[i] = tree[i * 2] % MOD * tree[i * 2 + 1] % MOD;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}
