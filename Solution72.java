package beginner;

//다음에 올 숫자
class Solution72 {
    public int solution(int[] common) {
        int answer = 0;
        //등차수열
        if((common[1] - common[0]) == (common[2] - common[1]))
            answer = common[common.length-1] + (common[1] - common[0]);
        //등비수열
				else 
            answer = common[common.length-1] * (common[1] / common[0]);
        
        return answer;
    }
}