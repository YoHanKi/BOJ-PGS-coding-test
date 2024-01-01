package beginner;

import java.util.HashMap;
import java.util.Map;

//로그인 성공?
class Solution70 {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> dbMap = new HashMap<String, String>();

        for (String[] strings : db) {
            dbMap.put(strings[0], strings[1]);
        }

        if (dbMap.containsKey(id_pw[0])) {
            if (dbMap.get(id_pw[0]).equals(id_pw[1])) {
                return "login";
            } else {
                return "wrong pw";
            }
        } else {
            return "fail";
        }
    }
}