class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int t1 = sec(h1,m1,s1), t2 = sec(h2,m2,s2);
        
        return caltime(t2) - caltime(t1) + (zero(t1)? 1 : 0);
    }
    
    public int sec(int h,int m,int s) {
        m += h * 60;
        s += m * 60;
        return s;
    }
    public int caltime(int time) {
        int hTime = time * 719/43200;
        int mTime = time * 59/3600;
        int except = time >= 43200 ? 2:1;
        return hTime + mTime - except;
    }
    public boolean zero(int time) {
        return time * 719 % 43200 == 0 || time * 59 % 3600 == 0;
    }
}