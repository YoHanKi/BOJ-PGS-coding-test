import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        for(String str : record) {
            String[] data = str.split(" ");
            int doing = in(data[0].charAt(0));
            String id = data[1];
            if(doing == 0) {
                map.put(id, data[2]);
                list.add(new Node(doing, id));
            } else if(doing == 1) {
                list.add(new Node(doing, id));
            } else {
                map.put(id, data[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(node.id)).append("님이 ");
            if(node.doing == 0) {
                sb.append("들어왔습니다.");
            } else {
                sb.append("나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    private int in(char c) {
        if(c=='E') return 0;
        else if(c=='L') return 1;
        else return 2;
    }
}
class Node {
    int doing; String id;
    public Node(int doing, String id) {
        this.doing = doing;
        this.id = id;
    }
}