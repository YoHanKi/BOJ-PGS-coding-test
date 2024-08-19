import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        //HashMap으로 스킬 레벨을 지정
        int level = 1;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : skill.toCharArray()) {
            map.put(ch, level++);
        }
        //반복문으로 검사 시 없다면, continue/ 있다면 현재 레벨과 비교
        for(String tree : skill_trees) {
            level = 1;
            for(char ch : tree.toCharArray()) {
                if(!map.containsKey(ch)) continue;
                else {
                    if(level != map.get(ch)) {
                        level = 0;
                        break;
                    }
                    level++;
                }
            }
            if(level > 0) answer++;
        }
        return answer;
    }
}