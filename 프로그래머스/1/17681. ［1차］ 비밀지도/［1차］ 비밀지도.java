class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i] | arr2[i];
            answer[i] = String.format("%"+n+"s",Integer.toBinaryString(temp)
                                      .replace("1", "#").replace("0", " "));
        }
        
        return answer;
    }
}