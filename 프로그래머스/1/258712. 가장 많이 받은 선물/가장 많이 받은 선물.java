import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> index = new HashMap<>();
        int[][] graph = new int[friends.length][friends.length];
        int[] factor = new int[friends.length];
        int answer = 0;
        
        for(int i = 0; i < friends.length; i++) index.put(friends[i], i);
        for(int i = 0; i < gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            factor[index.get(tmp[0])]++;
            factor[index.get(tmp[1])]--;
            graph[index.get(tmp[0])][index.get(tmp[1])]++;
        }
        
        for(int i = 0; i < graph.length; i++) {
            int max = 0;
            for(int j = 0; j < graph.length; j++) {
                if(i == j) continue;
                if(graph[i][j] > graph[j][i]) max++;
                else if (graph[i][j] == graph[j][i] && factor[i] > factor[j]) max++;
            }
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
}