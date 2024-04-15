class Solution {
    public int solution(int storey) {
        int answer = 0;
        int copy = storey;
        int tmp = 0;
        
        while (copy != 0) {
            tmp = copy % 10;
            copy /= 10;
            
            if(tmp == 0) continue;
            
            if(tmp != 5) {
            if(tmp < 5) answer += tmp;
            else {
                answer += 10 - tmp;
                copy++;
                }
            } else {
                int tmp2 = copy;
                while(tmp2 % 10 != 5) {
                    if(tmp2 != 5) break;
                    else tmp2 /= 10;
                }
                if(tmp2 % 10 < 5) answer += 5;
            else {
                answer += 5;
                copy++;
                }
            }
        }
        return answer;
    }

}