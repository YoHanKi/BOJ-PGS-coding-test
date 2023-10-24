package beginner;
 
//피자 나누기
class Solution3 {
    public int solution(int n) {
        int answer = 1;
        
        while((6*answer) % n != 0) {
            answer++;
        }
        return answer;
    }
}
/* 최대공약수와 최소공배수를 구하는 식
class Solution {
    public int GCD(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2, num1 % num2);
    }

    public int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }

    public int solution(int n) {
        return LCM(n, 6) / 6;
    }
}
*/