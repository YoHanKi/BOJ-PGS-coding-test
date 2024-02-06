import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //Add, Remove 메서드를 사용하기 위해 상수 선언
    static int[] checkArr;
    static int[] stateArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        char[] A = new char[S];
        checkArr = new int[4];
        stateArr = new int[4];
        checkSecret = 0;
        //문자열을 바로 배열로 받기 위해 toCharArray 사용
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) checkSecret++;
        }
        //슬라이딩 윈도우 사용 전 범위를 미리 확인
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if(checkSecret == 4) count++;
        //슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            //i는 윈도우 끝부분, j는 윈도우 첫부분
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            //반복문에서 i가 증가하면 자연스럽게 j도 증가.Add, Remove 하여 확인
            if(checkSecret == 4) count++;
        }
        System.out.println(count);
        br.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                stateArr[0]++;
                if(stateArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C' :
                stateArr[1]++;
                if(stateArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G' :
                stateArr[2]++;
                if(stateArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T' :
                stateArr[3]++;
                if(stateArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if(stateArr[0] == checkArr[0])
                    checkSecret--;
                stateArr[0]--;
                break;
            case 'C' :
                if(stateArr[1] == checkArr[1])
                    checkSecret--;
                stateArr[1]--;
                break;
            case 'G' :
                if(stateArr[2] == checkArr[2])
                    checkSecret--;
                stateArr[2]--;
                break;
            case 'T' :
                if(stateArr[3] == checkArr[3])
                    checkSecret--;
                stateArr[3]--;
                break;
        }
    }
}

