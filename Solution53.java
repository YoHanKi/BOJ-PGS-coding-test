package beginner;


//7의 개수
class Solution53 {
    public int solution(int[] array) {
        int answer = 0;
        
        //String으로 변환 후 7을 찾으면 answer 에 1을 합산
        for(int i=0 ; i < array.length; i++) {
        String[] arr = String.valueOf(array[i]).split("");
            for(int j= 0; j < arr.length; j++) {
                if(arr[j].equals("7"))
                    answer++;
            }
        }
        return answer;
    }
}