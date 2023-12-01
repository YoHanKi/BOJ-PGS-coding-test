package beginner;

//가장 큰 수 찾기
class Solution41 {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        //answer[0] 에서 큰수 대입하기
        for(int i = 0; i < array.length-1; i++) {
            if(array[i] < array[i+1]){
                answer[0] = array[i+1];
            } else answer[0] = array[i];
        }
        //대입한 큰 수와 큰수에 맞는 인덱스 찾기
        for(int i = 0; i < array.length; i++) {
            if(answer[0] == array[i])
                answer[1] = i;
        }
        return answer;
    }
}