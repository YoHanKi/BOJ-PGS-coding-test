package beginner;
 
//피자 나누기(3)
class Solution4 {
    public int solution(int slice, int n) {
        int answer = 0;

        return answer = (n%slice>0) ? n/slice+1 : n/slice;
    }
}