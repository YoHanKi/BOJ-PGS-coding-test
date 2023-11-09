package beginner;

import java.util.HashMap;
import java.util.Map;

//모스부호(1)
class Solution19 {
	    public String solution(String letter) {
	        String answer = "";
	        Map<String, String> morseMap = new HashMap<>() {
	            {
	        put(".-","a");  put("-...","b"); put("-.-.","c"); put("-..","d"); put(".","e");
	         put("..-.","f"); put("--.","g"); put("....","h");     put("..","i");
	         put(".---","j"); put("-.-","k"); put(".-..","l"); put("--","m");
	         put("-.","n"); put("---","o"); put(".--.","p"); put("--.-","q");
	         put(".-.","r"); put("...","s"); put("-","t"); put("..-","u");
	         put("...-","v"); put(".--","w"); put("-..-","x"); put("-.--","y");
	         put("--..","z");
	            }
	        };
	        String[] morse = letter.split(" ");
	        for(String m : morse) {
	            answer+=morseMap.get(m);
	        }
	        return answer;
	    }
	}