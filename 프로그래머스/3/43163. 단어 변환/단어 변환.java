import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.str.equals(target)) return now.index;
            for (int i = 0; i < words.length; i++) {
                if (!check(now.str, words[i])) continue;
                if (visited[i]) continue;
                visited[i] = true;
                queue.offer(new Node(words[i], now.index + 1));
            }
        }
        return 0;
    }

    public boolean check(String now, String word) {
        char[] nowC = now.toCharArray();
        char[] wordC = word.toCharArray();

        int diff = 0;
        for (int i = 0; i < nowC.length; i++) {
            if (nowC[i] != wordC[i]) diff++;
        }
        return diff == 1;
    }

    private static class Node {
        String str;
        int index;
        public Node(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }
}