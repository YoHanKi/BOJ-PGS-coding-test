import java.util.*;

class Solution {
    static final int N = 50;
    static final int SIZE = N * N;
    static int[] parent = new int[SIZE];
    static String[] value = new String[SIZE];

    public static String[] solution(String[] commands) {
        for (int i = 0; i < SIZE; i++) {
            parent[i] = i;
            value[i] = "";
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] parts = command.split(" ");
            String cmd = parts[0];
            if (cmd.equals("UPDATE")) {
                if (parts.length == 4) {
                    int p = find(id(parts[1], parts[2]));
                    value[p] = parts[3];
                } else {
                    String oldValue = parts[1];
                    String newValue = parts[2];
                    for (int i = 0; i < SIZE; i++) {
                        if (parent[i] == i && value[i].equals(oldValue)) value[i] = newValue;
                    }
                }
            } else if (cmd.equals("MERGE")) {
                int p1 = find(id(parts[1], parts[2]));
                int p2 = find(id(parts[3], parts[4]));
                if (p1 != p2) {
                    if (value[p1].isEmpty() && !value[p2].isEmpty()) parent[p1] = p2;
                    else parent[p2] = p1;
                }
            } else if (cmd.equals("UNMERGE")) {
                int p = find(id(parts[1], parts[2]));
                String cellValue = value[p];
                List<Integer> toUnmerge = new ArrayList<>();
                for (int i = 0; i < SIZE; i++) {
                    if (find(i) == p) toUnmerge.add(i);
                }
                for (int cell : toUnmerge) {
                    parent[cell] = cell;
                    value[cell] = "";
                }
                value[id(parts[1], parts[2])] = cellValue;
            } else if (cmd.equals("PRINT")) {
                int p = find(id(parts[1], parts[2]));
                if (value[p].isEmpty()) answer.add("EMPTY");
                else answer.add(value[p]);
            }
        }
        return answer.toArray(new String[0]);
    }

    public static int id(String r, String c) {
        int row = Integer.parseInt(r);
        int col = Integer.parseInt(c);
        return (row - 1) * N + (col - 1);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}