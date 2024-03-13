class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i = 3; i < sum/2; i++) {
            if(sum % i != 0) continue;
            if((i - 2) * (sum/i - 2) == yellow) 
                return new int[]{sum/i, i};
        }
        return answer;
    }
}