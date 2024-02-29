import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * [BOJ] 서로 다른 부분 문자열의 개수 (11478) / 실버3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                set.add(S.substring(i,j));
            }
        }
        System.out.println(set.size());
    }
}
