package beginner;

import java.util.Arrays;

//옹알이(1)
class Solution69 {
    public int solution(String[] babbling) {
        String[] able = {"aya", "ye", "woo", "ma"};

        return (int) Arrays.stream(babbling)
                    .map(s -> { for(String i : able) {
                        s = s.replace(i, "-"); }
                     return s;
                    })
                    .map(s -> s.replace("-", ""))
                    .filter(String::isEmpty)
                    .count();
    }
}