class Solution {
    public int solution(int n) {
        int answer = 0;
        String stringBin = Integer.toString(n,2);
        char[] charArray = stringBin.toCharArray();
        
        int count = 0;
        for(char c : charArray) {
            if (c == '1') count++;
        }
        
        for(int i = n + 1; i < n * 2; i++) {
            int countTemp = 0;
            char[] temp = Integer.toString(i, 2).toCharArray();
            for(char c : temp) if (c == '1') countTemp++;
            
            if(count==countTemp) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}