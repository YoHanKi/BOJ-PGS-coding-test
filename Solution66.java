package beginner;

//유한소수 판별하기
class Solution66 {
    public int solution(int a, int b) {
	//최대공약수로 기약분수로 만들기
        int GCD = gcd(a,b);
        int A = a / GCD;
        int B = b / GCD;
    //소인수가 2와 5일 시 1, 이외 2를 반환
        return answer(B) ? 1 : 2;
    }
    
    //유클리드 호제법을 사용한 최대공약수 구하기
    public int gcd(int num1,int num2) {
        
        if(num1 % num2 == 0) {
        return num2;
        } 
        return gcd(num2, (num1 % num2));
    }
    
    //소인수 2와 5만 존재하는지 확인하기
    public boolean answer(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}