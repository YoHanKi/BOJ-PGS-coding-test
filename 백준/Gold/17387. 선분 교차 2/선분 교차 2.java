import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [BOJ] 선분교차2 (17387) / 골드 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());
        long x4 = Integer.parseInt(st.nextToken());
        long y4 = Integer.parseInt(st.nextToken());
        boolean cross = isCross(x1,y1,x2,y2,x3,y3,x4,y4);
        if (cross) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int abc = CCW(x1,y1,x2,y2,x3,y3);
        int abd = CCW(x1,y1,x2,y2,x4,y4);
        int cda = CCW(x3,y3,x4,y4,x1,y1);
        int cdb = CCW(x3,y3,x4,y4,x2,y2);
        if (abc * abd == 0 && cda * cdb == 0) {
            return isOverlab(x1,y1,x2,y2,x3,y3,x4,y4);
        } else if (abc * abd <= 0 && cda * cdb <= 0) {
            return true;
        }
        return false;
    }

    //백터가 모두 충족되더라도, 같은 선상에 있을 경우를 고려
    private static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if (    Math.min(x1,x2) <= Math.max(x3,x4) &&
                Math.min(x3,x4) <= Math.max(x1,x2) &&
                Math.min(y1,y2) <= Math.max(y3,y4) &&
                Math.min(y3,y4) <= Math.max(y1,y2)) return true;
        //그림을 그려본다면 이해하기 편하다.
        return false;
    }
    //세점의 방향성을 계산
    private static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long tmp = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        if (tmp > 0) return 1;
        else if (tmp < 0) return -1;
        return 0;
    }
}
