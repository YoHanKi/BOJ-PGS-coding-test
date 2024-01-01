package beginner;

//연속된 수의 합
class Solution71 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int mid = (int)Math.ceil((double)total/num);
        int start = mid - num/2;
        
        for(int i = 0; i < num; i++) {
            int count = start;
                answer[i] = start++;
        }
        return answer;
    }
}