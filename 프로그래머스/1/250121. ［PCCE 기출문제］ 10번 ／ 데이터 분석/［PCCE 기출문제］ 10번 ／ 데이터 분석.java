import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int search = find(ext);
        int sortBy = find(sort_by);
        
        for(int[] i : data) {
            if(i[search] < val_ext) list.add(i);
        }
        
        Collections.sort(list,(o1,o2) -> o1[sortBy] - o2[sortBy]);
        int[][] answer = list.toArray(new int[list.size()][]);
        return answer;
    }
    
    public int find(String str) {
        int search = 0;
        switch(str) {
            case "code" -> search = 0;
            case "date" -> search = 1;
            case "maximum" -> search = 2;
            case "remain" -> search = 3;
        }
        return search;
    }
}