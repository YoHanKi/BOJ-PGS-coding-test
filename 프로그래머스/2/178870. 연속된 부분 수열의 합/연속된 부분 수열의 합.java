class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        //모든 범위의 최소를 구해야하므로, 끝까지 탐색해야함
        while(end < sequence.length) {
            sum += sequence[end];
            
            //만약 k보다 sum이 높다면 start를 빼주고, start 인덱스를 1 증가시킴
            while (sum > k && start <= end) {
                sum -= sequence[start++];
            }
            
            if(sum == k) {
                //최소 길이(minLength)가 현재 end - start 보다 크다면 변경
                if((end - start) < minLength) {
                    minLength = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            end++;
        }

        return answer;
    }
}