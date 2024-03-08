import java.util.Stack;

public class Solution {
    public int solution(int[] numbers, int target) {
        Stack<int[]> s = new Stack<>();
        int count = 0;
        s.push(new int[]{0,0});
        while(!s.isEmpty()) {
            int[] now = s.pop();
            if(now[0] == numbers.length) {
                if(now[1] == target) count++;
                continue;
            }
            s.push(new int[]{now[0] + 1, now[1] + numbers[now[0]]});
            s.push(new int[]{now[0] + 1, now[1] - numbers[now[0]]});
        }
        return count;
    }
}