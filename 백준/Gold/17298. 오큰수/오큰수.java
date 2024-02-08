import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //스택 활용
        Stack<Integer> stack = new Stack<>();
        //조건문에서 스택이 비어있는지와 peek을 진행하므로, 0을 하나 넣어준다.
        stack.push(0);
        //배열의 크기만큼 반복문
        for (int i = 0; i < N; i++) {
            //스택이 비어있지않고, arr[stack.peek()]이 arr[i]보다 크다면
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // 정답배열[stack.pop]에 추가
                answer[stack.pop()] = arr[i];
            }
            //스택이 비어있고, arr[stack.peek()]이 arr[i]보다 작거나 같다면 stack에 검사할 배열 인덱스 추가
            stack.push(i);
        }
        //스택에 남아있는 곳이 있다면 pop으로 제거하면서 -1 입력
        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        //정답 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}