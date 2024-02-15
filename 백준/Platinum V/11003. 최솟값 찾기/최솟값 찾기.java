/**
 * 출처 : BAEKJOON
 * 문제 : 최솟값 찾기 (11003)
 * 난이도 : 플래티넘 5
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.getLast() > nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(i >= L) {
                if (nums[i - L] == deque.getFirst()){
                    deque.removeFirst();
                }
            }
            bw.write(deque.getFirst() + " ");
        }

        bw.flush();
        bw.close();
    }
}
