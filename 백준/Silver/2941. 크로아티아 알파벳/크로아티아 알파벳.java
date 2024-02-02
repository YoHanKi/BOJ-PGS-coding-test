import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String alpha = br.readLine();
        //replaceAll로 치환
        for(int i = 0 ; i < croa.length ; i++) {
            //개수만 반환하면 되기 때문에 바꿀필요없이 " "로 치환
            alpha = alpha.replaceAll(croa[i], " ");
        }
        //개수를 반환
        System.out.println(alpha.length());
    }
}