import java.util.*;
 
// public class Solution {
//     public int solution(int[] citations) {
//         int answer = 0;
//         Arrays.sort(citations);
 
//         for (int i = 0; i < citations.length; i++) {
//             int h = citations.length - i;
 
//             if (citations[i] >= h) {
//                 answer = h;
//                 break;
//             }
//         }
//         return answer;
//     }
// }

class Solution {
    public int solution(int[] citations) {
      
        Arrays.sort(citations);    
        for(int i=citations.length; i>0; i--){
            if(citations[citations.length-i] >= i) return i;
        }
        return 0;
    }
}