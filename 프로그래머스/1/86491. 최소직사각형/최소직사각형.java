class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] diagram = new int[2];
        int maxW = 0, maxH = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxW * maxH;
    }
}