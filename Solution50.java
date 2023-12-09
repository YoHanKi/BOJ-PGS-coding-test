package beginner;

//세균 증식
class Solution50 {
    public int solution(int n, int t) {
        int answer = n;
            for(int i = 1; i <= t; i ++) {
                answer = answer * 2;
            }
        return answer;
    }
}

// class Solution {
//public int solution(int n, int t) {
//    int answer = 0;
//
//    answer = n << t;
//
//    return answer;
//}
//}