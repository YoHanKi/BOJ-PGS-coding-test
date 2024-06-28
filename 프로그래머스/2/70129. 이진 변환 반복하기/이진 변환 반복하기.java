class Solution {
    public int[] solution(String s) {
        int cntTime = 0;
        int cntNum = 0;
        
        while(!s.equals("1")) {
            cntTime++;
            int zero = s.replace("1", "").length();
            cntNum += zero;
            s = Integer.toBinaryString(s.length() - zero);
        }
        
        return new int[]{cntTime, cntNum};
    }
}