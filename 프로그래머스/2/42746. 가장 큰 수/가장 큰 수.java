import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> numList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(String.valueOf(numbers[i]));
        }
        numList.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });
        
        if(numList.get(0).charAt(0) == '0') return "0";
        
        StringBuffer sb = new StringBuffer();
        for(String num : numList) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}