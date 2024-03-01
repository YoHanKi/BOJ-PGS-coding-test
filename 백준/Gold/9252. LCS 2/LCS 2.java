import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * [BOJ] LCS2 (9252) / 골드 4
 * 최장 공통 부분수열(Longest Common Subsequence)
 * 최장 공통 문자열(Longest Common Substring)
 * 의 차이를 이해하고 풀어야한다.
 */
public class Main {
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        DP = new int[A.length + 1][B.length + 1];

        // 바텀업 방식으로 DP 테이블 채우기
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                //문자가 동일하다면
                if (A[i - 1] == B[j - 1]) {
                    //대각선 배열 + 1
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    //동일하지 않다면, 좌측이나 위측 중 큰 배열을 삽입
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[A.length][B.length]);

        // 바텀 업 방식
        StringBuilder lcs = new StringBuilder();
        int i = A.length, j = B.length;
        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                lcs.append(A[i - 1]);
                i--;
                j--;
            } else if (DP[i - 1][j] > DP[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(lcs.reverse());
    }
}
