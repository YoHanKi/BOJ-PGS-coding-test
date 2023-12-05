package beginner;

//n의 배수
class Solution45 {
    public int[] solution(int n, int[] numlist) {
        int num = 0; 
        int cnt = 0; //answer의 배열 길이 측정
        
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0) {
                cnt++;
            }
        }//배열길이를 측정하여 대입
        int[] answer = new int[cnt];
        
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0) {
                answer[num] = numlist[i];
                num++;
            }
        }
        return answer;
    }
}