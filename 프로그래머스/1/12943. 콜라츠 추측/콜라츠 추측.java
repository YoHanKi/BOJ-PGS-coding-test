class Solution {
    public int solution(int num) {
        long number = num;
        int answer = 0;
        
        while(answer < 500) {
            if(number == 1) break;
            if(number%2 == 0) {
                number /= 2;
                answer++;
            } else {
                number = (number * 3) + 1;
                answer++;
            }
        }
        if (answer >= 500) return -1;
        return answer;
    }
}