class Solution {
    public int solution(int n) {
        int answer = 1;
        int[] cal = new int[n];
        for(int i=1; i < cal.length; i++) cal[i] = cal[i-1] + i;
        
        int left = 0;
        int right = 1;
        while(right < cal.length) {
            if(cal[right] - cal[left] < n) {
                right++;
            }else if(cal[right] - cal[left] > n) {
                left++;
            } else if(cal[right] - cal[left] == n) {
                right++;
                left++;
                answer++;
            }
        }
        return answer;
    }
}