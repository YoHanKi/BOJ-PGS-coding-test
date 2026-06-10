import java.util.*;

class Solution {
    public static Stack<String[]> st;
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, (a, b) -> {
            return timeToInt(a[1]) - timeToInt(b[1]);
        });
        // System.out.println(intToTime(720));
        st = new Stack<>();
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < plans.length - 1; i++) {
            int sT = timeToInt(plans[i][1]);
            int eT = sT + Integer.parseInt(plans[i][2]);
            int nsT = timeToInt(plans[i + 1][1]);
            
            if (eT > nsT) {
                // 다 못끝낼거니까 스택에 넣어놓되, 시간과 남은 시간을 계산해서 처리해둠
                int gap = nsT - sT;
                String sTAdd = intToTime(sT + gap);
                plans[i][1] = sTAdd;
                plans[i][2] = (Integer.parseInt(plans[i][2]) - gap) + "";
                st.push(plans[i]);
            } else {
                // 끝냄 → result에 넣고, 빈 시간(gap) 동안 스택 비우기
                result.add(plans[i][0]);
                int gap = nsT - eT;

                while (!st.isEmpty() && gap > 0) {
                    String[] plan = st.pop();
                    int t = Integer.parseInt(plan[2]);        // 남은 시간

                    if (t <= gap) {            // 빈 시간 안에 완료
                        result.add(plan[0]);
                        gap -= t;
                    } else {                   // 못 끝냄 → 갱신 후 다시 스택
                        plan[2] = (t - gap) + "";
                        st.push(plan);
                        break;
                    }
                }
            }
        }

        // 3. 마지막 과제 + 스택에 남은 것 전부 마무리
        result.add(plans[plans.length - 1][0]);
        while (!st.isEmpty()) {
            result.add(st.pop()[0]);
        }

        return result.toArray(new String[0]);
    }
    
    private int timeToInt(String str) {
        String[] times = str.split(":");
        int time = (Integer.parseInt(times[0]) * 60) + (Integer.parseInt(times[1]));
        return time;
    }
    
    private String intToTime(int time) {
        int hh = time / 60;
        int mm = time % 60;
        return hh + ":" + String.format("%02d",mm);
    }
}