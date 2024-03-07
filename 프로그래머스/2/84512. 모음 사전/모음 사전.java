class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] sum = {781, 156, 31, 6, 1};
        char[] words = word.toCharArray();

        for (int i = 0; i < words.length; i++) {
            switch (words[i]) {
                case 'A':
                    answer += 1;
                    break;
                case 'E':
                    answer += 1 + sum[i];
                    break;
                case 'I':
                    answer += 1 + 2 * sum[i];
                    break;
                case 'O':
                    answer += 1 + 3 * sum[i];
                    break;
                case 'U':
                    answer += 1 + 4 * sum[i];
                    break;
            }
        }
        return answer;
    }
}