class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y,int size) {
        //같은 숫자인지 확인
        int num = arr[x][y];
        boolean check = true;
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != num) check = false;
            }
        }
        //숫자가 같다면, arr[x][y] 위치의 값을 +1
        if(check) answer[num]++;
        //숫자가 다르다면 4개의 영역으로 나눠서 확인
        else {
            int newSize = size/2;
            compress(arr, x, y, newSize);
            compress(arr, x, y + newSize, newSize);
            compress(arr, x + newSize, y, newSize);
            compress(arr, x + newSize, y + newSize, newSize);
        }
    }
}