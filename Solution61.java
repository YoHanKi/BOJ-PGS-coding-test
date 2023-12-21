package beginner;

//숨어있는 숫자의 덧셈(2)
class Solution61 {
    public int solution(String my_string) {
		int answer = 0;
		String[] s = my_string.split("[a-zA-Z]");
		for (int i = 0; i < s.length; i++) {
			answer+= !s[i].isEmpty() ? Integer.parseInt(s[i]) :0;
		}
		return answer;
	}
}