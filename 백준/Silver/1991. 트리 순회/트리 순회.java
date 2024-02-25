import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 트리 순회 (1991) / 실버 1
 */
public class Main {
    static int [][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //알파벳을 숫자로 치환
            int node = Integer.parseInt(String.valueOf(st.nextToken().charAt(0) - 'A'));
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node][0] = left == '.' ? -1 : left - 'A';
            tree[node][1] = right == '.' ? -1 : right - 'A';
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int i) {
        //비어 있다면 리턴
        if (i == -1) return;
        System.out.print((char)(i + 'A')); //루트
        preOrder(tree[i][0]);              //왼쪽
        preOrder(tree[i][1]);              //오른쪽
    }

    private static void inOrder(int i) {
        if (i == -1) return;
        inOrder(tree[i][0]);
        System.out.print((char) (i + 'A'));
        inOrder(tree[i][1]);
    }

    private static void postOrder(int i) {
        if (i == -1) return;
        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        System.out.print((char)(i + 'A'));
    }

}
