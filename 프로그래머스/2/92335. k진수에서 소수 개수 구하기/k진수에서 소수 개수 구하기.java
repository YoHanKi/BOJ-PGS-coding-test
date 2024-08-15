import java.math.BigInteger;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        for(String s : Integer.toString(n, k).split("0")) {
            if(s.isEmpty()) continue;
            BigInteger num = new BigInteger(s);
            if (num.isProbablePrime(10)) {
                answer++;
            }
        }
        return answer;
    }
}