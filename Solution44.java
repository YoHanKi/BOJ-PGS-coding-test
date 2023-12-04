package beginner;

import java.util.stream.Stream;

//숫자 찾기
class Solution44 {
    public int solution(int num, int k) {
        int answer = 1;
        int[] arr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0 ; i < arr.length; i++) {
            if(arr[i] == k){
               return answer += i;
            }
        }
        return -1;
    }
}