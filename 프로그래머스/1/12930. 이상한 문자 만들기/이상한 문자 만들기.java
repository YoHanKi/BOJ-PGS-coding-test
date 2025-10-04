import java.util.*;

class Solution {
    public static String solution(String s) {
        char[] str = s.toCharArray();
        int gap = 'a' - 'A';
        char[] answers = new char[str.length];

        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                answers[i] = ' ';
                count = 0;
                continue;
            }
            if (str[i] >= 'a' && str[i] <= 'z') {
                if (count % 2 == 0) {
                    answers[i] = (char) (str[i] - gap);
                } else {
                    answers[i] = str[i];
                }
            }
            if (str[i] >= 'A' && str[i] <= 'Z') {
                if (count % 2 == 0) {
                    answers[i] = str[i];
                } else {
                    answers[i] = (char) (str[i] + gap);
                }
            }
            count++;
        }

        return String.valueOf(answers);
    }
}