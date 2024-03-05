import java.util.*;

class Solution {
    static Map<String, PriorityQueue<String>> map;
    static ArrayList<String> answer = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();

        for (String[] ticket : tickets) {
        
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        DFS("ICN");

        return answer.toArray(new String[0]);
    }

    private void DFS(String start) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            DFS(pq.poll());
        }
        answer.add(0, start);
    }
}