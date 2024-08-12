import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.num - o1.num);
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            Node node = new Node(i, priorities[i]);
            pq.add(node);
            q.add(node);
        }
        
        int[] arr = new int[priorities.length];
        int count = 1;
        while(!q.isEmpty()) {
            if(q.peek().num != pq.peek().num) {
                q.add(q.poll());
            }
            else {
                Node tempNode = q.poll();
                int index = tempNode.index;
                int num = tempNode.num;
                arr[index] = count++;
                pq.poll();
            }
        }
        
        return arr[location];
    }
}

class Node {
    int index, num;
    Node(int index, int num) {
        this.index = index;
        this.num = num;
    }
}