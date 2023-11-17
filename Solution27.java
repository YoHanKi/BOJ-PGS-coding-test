package beginner;

//모음 제거
class Solution27 {
    public String solution(String my_string) {
        String answer = "";
        String[] replace = {"a", "e", "i", "o", "u"};		//모음 추가
        for(int i = 0; i<replace.length; i++) {				//replace의 모음을 돌면서
			if( my_string.contains(replace[i])) {			//모음이 존재한다면
				answer = my_string.replaceAll(replace[i], "");	//모든 모음 제거
				my_string = answer;
			} else {										//아니라면
                answer =my_string;							//결과 출력
            }
		}
        
        
        return answer;
    }
}