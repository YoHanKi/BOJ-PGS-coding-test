import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int get = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        Set<Integer> set = Arrays.stream(lost)
                .boxed().collect(Collectors.toSet());
        set.retainAll(Arrays.stream(reserve).boxed().collect(Collectors.toSet()));

        Queue<Integer> queue = new LinkedList<>();
        for (int l : lost) queue.offer(l);
        for (int r : reserve) {
            if (set.contains(r)) continue;
            while (!queue.isEmpty() && (queue.peek() < r-1 || set.contains(queue.peek()))) {
                queue.poll();
            }
            if (queue.isEmpty()) break;

            if (queue.peek() <= r+1) {
                queue.poll();
                get++;
            }
        }

        return n - lost.length + set.size() + get;
    }
}