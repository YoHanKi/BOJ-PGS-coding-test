class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        for(int i = 0; i < park.length; i++) {
            if(park[i].indexOf("S") != -1) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
            }
        }
        
        for (String s : routes) {
            String[] tmp = s.split(" ");
            String direction = tmp[0];
            int count = Integer.parseInt(tmp[1]);
            boolean block = false;

            switch(direction) {
                case "N":
                    for (int i = 1; i <= count; i++) {
                        if (answer[0] - i < 0 || park[answer[0] - i].charAt(answer[1]) == 'X') {
                            block = true;
                            break;
                        }
                    }
                    if (!block) answer[0] -= count;
                    break;
                case "S":
                    for (int i = 1; i <= count; i++) {
                        if (answer[0] + i >= park.length || park[answer[0] + i].charAt(answer[1]) == 'X') {
                            block = true;
                            break;
                        }
                    }
                    if (!block) answer[0] += count;
                    break;
                case "W":
                    for (int i = 1; i <= count; i++) {
                        if (answer[1] - i < 0 || park[answer[0]].charAt(answer[1] - i) == 'X') {
                            block = true;
                            break;
                        }
                    }
                    if (!block) answer[1] -= count;
                    break;
                case "E":
                    for (int i = 1; i <= count; i++) {
                        if (answer[1] + i >= park[answer[0]].length() || park[answer[0]].charAt(answer[1] + i) == 'X') {
                            block = true;
                            break;
                        }
                    }
                    if (!block) answer[1] += count;
                    break;
            }
        }
        return answer;
    }
}