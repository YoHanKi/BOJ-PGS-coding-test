import java.util.*;

class Solution {
    public static int solution(int[] players, int m, int k) {
        int time = players.length;

        int serversAdded = 0;
        int currentServers = 0;
        Map<Integer, Integer> serverMap = new HashMap<>();
        for (int i = 0; i < time; i++) {
            if (serverMap.containsKey(i)) {
                currentServers = Math.max(0, currentServers - serverMap.get(i));
                serverMap.remove(i);
            }
            if (players[i] > 0) {
                int requiredServers = players[i] / m;
                if (requiredServers > currentServers) {
                    int serversToAdd = requiredServers - currentServers;
                    serversAdded += serversToAdd;
                    currentServers += serversToAdd;
                    serverMap.put(i + k, serversToAdd);
                }
            }
        }

        return serversAdded;
    }
}