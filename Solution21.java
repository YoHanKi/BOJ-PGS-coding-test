package beginner;


//공 던지기
class Solution21 {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int i = 0;
        while(k>0) {
            answer = numbers[i%numbers.length];
            i+=2;
            k--;
        }
        return answer;
    }
}