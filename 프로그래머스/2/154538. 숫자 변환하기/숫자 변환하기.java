class Solution {
    public int solution(int x, int y, int n) {
        final int MAX = Integer.MAX_VALUE;
        //인덱스 위치를 x,y 값으로 사용하고, DP를 사용
        int[] num = new int[y+1];
        
        //i의 값에서 i-n, i/2, i/3이 x크고 정수라면 변수에 담아 가장 작은 값을 인덱스 i 에 +1 저장
        for(int i = x+1; i < num.length; i++) {
            int a = MAX, b = MAX, c = MAX;
            if(i-n >= x) a = num[i-n];
            if(i/2 >= x && i%2 == 0) b = num[i/2];
            if(i/3 >= x && i%3 == 0) c = num[i/3];
            
            int d = Math.min(Math.min(a, b), c);
            
            num[i] = d < MAX ? d+1 : MAX;
        }
        
        return num[y] < MAX ? num[y] : -1;
    }
}