package beginner;

import java.util.Arrays;

//삼각형의 완성조건(2)
class Solution63 {
    public int solution(int[] sides) {
        int answer = 0;                     //카운트할 대상
        Arrays.sort(sides);                 //수를 정렬
        int sum = sides[0] + sides[1];      //나머지 한 변이 가장 긴 변인 경우를 고려한 두 합
        int other = sides[1] +1 - sides[0]; //가장 긴 변이 sides[1] 인 경우를 고려한 나머지 변 길이
        
        
        //나머지 한 변이 가장 긴 변인 경우
        for(int i = sum - 1; i > sides[1] ; i--) {
            if(i < sum) answer++;
        }
        
        //가장 긴 변이 sides[1] 인 경우
        for(int i = sides[1]; i >= other; i--) {
            if(i < sum) answer++;
        }
        return answer;
    }
}