import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter 사용했으나 출력 초과 발생

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        //스택 활용
        Stack<Integer> stack = new Stack<>();
        //출력을 위한 sb 추가
        StringBuffer sb = new StringBuffer();
        int num = 1;
        //마지막에 sb 출력 여부를 위해 추가
        boolean result = true;
        
        
        for (int i = 0; i < N; i++) {
            //수열(num)이 data[i]보다 작거나 같다면
            if (data[i] >= num) {
                //반복하여 stack에 push
                while (data[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                //while문을 빠져나왔다면, num이 더 커진것이므로, pop
                stack.pop();
                sb.append("-\n");
            } else {
                //num이 더 커진것이므로, 조건문에서 pop 실행
                //수열(num)이 data[i]보다 작으며, stack의 top이 data보다 한번이라도 크다면 NO 출력 후 종료
                if(stack.pop() > data[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        //sb는 close 시 flush 실행 후 종료
        if(result) 
            System.out.println(sb.toString());
        br.close();
    }
}
