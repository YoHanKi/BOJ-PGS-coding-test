import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] strArr = str.split("-");

        //첫번째 배열은 기준이 되므로 answer 값
        int answer = splitSum(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            int tmp = splitSum(strArr[i]);
            //메서드로 더한 값들을 answer에 뺀다.
            answer -= tmp;
        }
        System.out.println(answer);
    }

    private static int splitSum(String s) {
        int sum = 0;
        //대괄호([])는 정규표현식으로 이를 생각하면 +가 메타 문자로 해석된다.
        String[] temp = s.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
