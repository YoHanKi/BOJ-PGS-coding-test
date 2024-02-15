import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
        public static void main(String[] args) throws IOException {
            // 10815 숫자 카드
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            Set<Integer> hashSet = new HashSet<>();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                hashSet.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            br.close();

            // 필요한 코드 작성
            for(int i = 0; i < arr.length ; i++) {
                if(hashSet.contains(arr[i])) bw.write("1 ");
                else bw.write("0 ");
            }
            bw.flush();
            bw.close();

    }
}
