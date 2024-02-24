import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 케빈 베이컨의 6단계 법칙 / 실버 1
 * 플로이드 워셜 문제
 */
public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        //인접행렬로 구현하기 위해 자기자신은 0, 나머지는 최대치로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) arr[i][j] = 0;
                    //MAX_VALUE 사용 시 플루이드 워셜 알고리즘에서 + 연산자로 인해 오버플로가 발생한다.
                else arr[i][j] = 10000001;
            }
        }
        //친구 관계를 구하는 것이므로, 양방향
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1; arr[e][s] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (arr[s][e] > arr[s][k] + arr[k][e]) arr[s][e] = arr[s][k] + arr[k][e];
                }
            }
        }
        //배열의 한줄의 합은 케빈 베이컨의 수, 즉 최소 케빈베이컨을 구하면 승자를 알 수 있다.
        int Min = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                tmp += arr[i][j];
            }
            if (Min > tmp) {
                Min = tmp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}

