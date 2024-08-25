class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            if((number & 1) == 0) {
                answer[i] = number + 1;
            } else {
                long bit = 1;
                while((number & bit) != 0) {
                    bit <<= 1;
                }
                answer[i] = (number | bit) & ~(bit >> 1);
            }
        }
        
        return answer;
    }
}