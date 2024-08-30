import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < board[0].length; i++) {
            Stack<Integer> stack = map.getOrDefault(i + 1, new Stack<Integer>());
            for(int j = board.length-1; j >= 0; j--) {
                if(board[j][i] != 0) {
                    stack.push(board[j][i]);
                    map.put(i+1, stack);
                }
            }
        }
        
        Stack<Integer> getStack = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            Stack<Integer> lineStack = map.get(moves[i]);
            if(lineStack.isEmpty()) continue;
            int getItem = lineStack.pop();
            if(!getStack.isEmpty() && getStack.peek() == getItem) {
                getStack.pop();
                answer += 2;
            } else {
                getStack.push(getItem);
            }
        }
        
        return answer;
    }
}