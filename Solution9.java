package beginner;


//문자열 뒤집기
class Solution9 {
  public String solution(String my_string) {
      String answer = "";
      //StringBuffer 멀티 쓰레드 , StringBulider 싱글 쓰레드
      StringBuffer sb = new StringBuffer(my_string);
      answer = sb.reverse().toString();
      
      return answer;
  }
}


/*char 배열로 담아 역순으로 배열하는 방식
* public String solution(String my_string) { String str = "abcde";
* 
* char[] arr = str.toCharArray(); // String -> char[] char[] reversedArr = new
* char[arr.length]; for(int i=0; i<arr.length; i++){
* reversedArr[arr.length-1-i] = arr[i]; }
* 
* String reversedStr = new String(reversedArr);
* System.out.println(reversedStr); // edcba } } }
*/