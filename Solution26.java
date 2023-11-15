package beginner;

//팩토리얼
class Solution26 {
    public int solution(int n) {
        int i = 1;      //팩토리얼 값
        int fact = 1;   //팩토리얼 적용한 값
        
        while(fact <= n) {  //n보다 크거나 같아질때까지 진행
            i++;
            fact *= i;
        }
        return i-1;   
    }
}