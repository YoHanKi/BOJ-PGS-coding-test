import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        //최대 값 탐색
        boolean[] arr = new boolean[10000001];

        //에라토스테네스의 체(소수 구하기)
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == true) continue;
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = true;
            }
        }

        for (int i = Integer.parseInt(N); i < arr.length; i++) {
            //소수이면서
            if (!arr[i]) {
                //팰린드롬인 수는
                if (change(i)) {
                    //출력 후 종료
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    private static boolean change(int k) {
        //투포인터로 확인
        char[] strArr = String.valueOf(k).toCharArray();
        int pointer1 = 0;
        int pointer2 = strArr.length - 1;

        while (pointer1 <= pointer2) {
            if (strArr[pointer1] != strArr[pointer2]) return false;

                pointer1++;
                pointer2--;
        }
    return true;
    }
}
