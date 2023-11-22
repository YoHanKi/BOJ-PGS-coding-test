package beginner;

//삼각형의 완성조건 (1)
class Solution32 {
    public int solution(int[] sides) {
        int max = 0;
        int tsum = sides[sides.length-1];

        for(int i = 0; i < sides.length-1 ; i++) {
            tsum += sides[i];
            if(sides[i] > sides[i+1]) {
                max = sides[i];
            } else max = sides[sides.length-1];
        } 
        return max >= tsum-max ? 2 : 1 ;
    }
}