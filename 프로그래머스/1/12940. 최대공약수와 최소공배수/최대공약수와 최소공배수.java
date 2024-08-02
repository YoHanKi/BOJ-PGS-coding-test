class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int a = n;
        int b = m;
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
        }
        
        answer[0] = a;
        answer[1] = (n*m)/answer[0];
        return answer;
    }
}