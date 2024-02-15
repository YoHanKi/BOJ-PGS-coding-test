import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
        public static void main(String[] args) {
            // 10815 숫자 카드
            Scanner sc = new Scanner(System.in);
            Set<Integer> hashSet = new HashSet<>();



            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                hashSet.add(sc.nextInt());
            }
            int M = sc.nextInt();
            int[] arr1 = new int[M];
            int[] answer = new int[M];

            for (int i = 0; i < M; i++) {
                arr1[i] = sc.nextInt();
            }
            // 필요한 코드 작성
            for(int i = 0; i < arr1.length ; i++) {
                if(hashSet.contains(arr1[i])) answer[i] = 1;
                else answer[i] = 0;
            }
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(answer[i] + " ");
            }
    }
}