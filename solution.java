package beginner;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;
        
        int min = Math.min(denom, numer);
        for(int i=2 ; i<= min ; i++) {
            if(denom % i == 0 && numer % i == 0){
                denom /= i;
                numer /= i;
                i = 1;
            }
        } 
    answer[0] = numer;
    answer[1] = denom; 
        
        return answer;
        //유클리드 호제법
//        public int gcd(int num1, int num2) {
//        	if(num1 % num2 == 0) {
//        	return num2;
//        	} return gcd(num2, (num1 % num2));
//        }
    }
}