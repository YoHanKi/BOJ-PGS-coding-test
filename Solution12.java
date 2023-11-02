package beginner;

//각도기
class Solution12 {
    public int solution(int angle) {
        return
        angle == 180 ?  4 : 
        90 < angle && angle < 180 ?  3 :
        angle == 90 ?  2 :
        0<angle && angle < 90 ?  1 : -1;
    }
}