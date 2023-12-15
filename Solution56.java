package beginner;

//직사각형 넓이 구하기
class Solution56 {
    public int solution(int[][] dots) {
        int w=0, h =0;
        int x = dots[0][0];
        int y = dots[0][1];
        
        for(int i=0; i<dots.length; i++){
            if(x!= dots[i][0]) w = Math.abs(x-dots[i][0]);
            if(y!= dots[i][1]) h = Math.abs(y-dots[i][1]);
        }
        return w*h;
    }
}