import java.util.*;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentSum = current[0];
            int currentIndex = current[1];

            if (currentIndex == numbers.length) { 
                if (currentSum == target) {
                    answer++; 
                }
            } else {
                int nextNumber = numbers[currentIndex];
                queue.add(new int[]{currentSum + nextNumber, currentIndex + 1}); 
                queue.add(new int[]{currentSum - nextNumber, currentIndex + 1}); 
            }
        }

        return answer;
    }
}


//         Stack<State> s = new Stack<>();
//         s.push(new State(0, 0));
//         int count = 0;
//         while (!s.isEmpty()) {
//             State state = s.pop();
//             if (state.index == numbers.length) {
//                 if (state.acc == target) count++;
//                 continue;
//             }
//             s.push(new State(state.index + 1, state.acc - numbers[state.index]));
//             s.push(new State(state.index + 1, state.acc + numbers[state.index]));
//         }
//         return count;
//     }
    
//     private static class State {
//         public final int index;
//         public final int acc;

//         State(int index, int acc) {
//             this.index = index;
//             this.acc = acc;
//         }
//     }
// }


// class Solution {
//     static int answer;
//     static int[] numbers;
//     static int target;
    
//     public int solution(int[] numbers, int target) {
//         answer = 0;
//         this.numbers = numbers;
//         this.target = target;
        
//         dfs(0,0);
//         return answer;
//     }
    
//     public void dfs(int i, int sum){
//         if(i == numbers.length){
//             if(sum == target){
//                 answer++;
//             }
//         return;
//         }
//         // 양갈래
//         dfs(i+1,sum+numbers[i]);
//         dfs(i+1,sum-numbers[i]);
//     }
// }