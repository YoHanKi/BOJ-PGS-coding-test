import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visited;
    boolean[] primes;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        DFS(numbers, "", 0);
        int maxValue = Collections.max(set);
        primes = new boolean[maxValue+1];
        primes[0] = primes[1] = true;
        
        for(int num : set) {
            if(primes[num]) continue;
            for(int i = 2; i <= Math.sqrt(primes.length); i++) {
                if(primes[i]) continue;
                for(int j = i+i; j < primes.length; j += i) {
                    if(!primes[j]) {
                        primes[j] = true;
                        if(j==num) break;
                    }
                }
            }
            if(!primes[num]) answer++;
        }
        
        return answer;
    }
    
    private void DFS(String numbers, String s, int depth) {
        if(depth > numbers.length()) return;
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                DFS(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
}