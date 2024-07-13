class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliPointer = n - 1;
        int pickPointer = n - 1;
        
        while (deliPointer >= 0 && deliveries[deliPointer] == 0) deliPointer--;
        while (pickPointer >= 0 && pickups[pickPointer] == 0) pickPointer--;
        
        while (deliPointer >= 0 || pickPointer >= 0) {
            answer += (Math.max(deliPointer, pickPointer)+1)*2L;
            deliPointer = getMaxIdx(cap, deliveries, deliPointer);
            pickPointer = getMaxIdx(cap, pickups, pickPointer);
        }
        
        return answer;
    }
    
    private static int getMaxIdx(int cap, int[] target, int pointer) {
        while (pointer >= 0 && (cap > 0 || target[pointer] == 0)) {
            if (target[pointer] > cap) {
                target[pointer] -= cap;
                cap = 0;
            }
            else {
                cap -= target[pointer];
                target[pointer] = 0;
                pointer--;
            }
        }
        return pointer;
    }
}