class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length+1];
        
        int last = num_list[num_list.length-1];
        int lastSecond = num_list[num_list.length-2];
        
        for(int i=0 ; i < num_list.length ; i++) {
            answer[i] = num_list[i];
        }
        
        if(last > lastSecond) {
            answer[answer.length-1] = last - lastSecond;
        } else {
            answer[answer.length-1] = last * 2;
        }
        
        
        return answer;
    }
}