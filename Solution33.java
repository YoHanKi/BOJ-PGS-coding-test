package beginner;

//가까운수
class Solution33 {
	public int solution(int[] array, int n) {
        int answer = 0;
        int diff = 0;
        int min = 101; //원소는 최대 100까지 이므로 최대치 Integer.MAX_VALUE 또는 101로 설정해도 된다.

        for (int i = 0; i < array.length; i++) {
            diff = Math.abs(n - array[i]);
            if (diff < min) {	//만약 min값을 0으로 초기화시, 이부분에서 에러가 발생
                min = diff;
                answer = array[i];

            } else if (diff == min && array[i] < answer) {
                answer = array[i];
            }
        }

        return answer;
    }
}