import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BitSet[] gears = new BitSet[4];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            gears[i] = new BitSet(8);
            for (int j = 0; j < 8; j++) {
                if (line.charAt(j) == '1') {
                    gears[i].set(j);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            String[] input = br.readLine().split(" ");
            int gearIndex = Integer.parseInt(input[0]) - 1;
            int clockwise = Integer.parseInt(input[1]);

            int[] toRotate = new int[4];
            toRotate[gearIndex] = clockwise;

            for (int i = gearIndex; i < 3; i++) {
                if (gears[i].get(2) != gears[i + 1].get(6)) {
                    toRotate[i + 1] = toRotate[i] == 1 ? -1 : 1;
                } else {
                    toRotate[i + 1] = 0;
                    break;
                }
            }

            for (int i = gearIndex; i > 0; i--) {
                if (gears[i].get(6) != gears[i - 1].get(2)) {
                    toRotate[i - 1] = toRotate[i] == 1 ? -1 : 1;
                } else {
                    toRotate[i - 1] = 0;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (toRotate[i] != 0) {
                    gears[i] = rotation(gears[i], toRotate[i]);
                }
            }
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].get(0)) {
                score += (1 << i);
            }
        }
        System.out.println(score);
    }

    public static BitSet rotation(BitSet gears, int clockwise) {
        if (clockwise == 1) {
            boolean last = gears.get(7);
            BitSet copy = new BitSet(8);
            for (int i = 0; i < 7; i++) {
                copy.set(i + 1, gears.get(i));
            }
            copy.set(0, last);
            return copy;
        } else if (clockwise == -1) {
            boolean first = gears.get(0);
            BitSet copy = new BitSet(8);
            for (int i = 0; i < 7; i++) {
                copy.set(i, gears.get(i + 1));
            }
            copy.set(7, first);
            return copy;
        } else {
            return gears;
        }
    }
}
