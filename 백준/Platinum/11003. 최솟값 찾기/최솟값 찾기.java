import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //데이터의 양이 많을 때는 bw를 사용하여 한번에 출력하는 것이 효율적이다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        //ArrayDeque를 사용
        Deque<Node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            //바로 deque에 적재하는 것보다 검증 후 적재하는 것이 조금 더 빠르다.
            int num = Integer.parseInt(st.nextToken());
            //데이터 검증(비어있지 않고, 데이터가 num보다 크다면 최신 데이터 삭제 => 반복)
            while (!deque.isEmpty() && deque.getLast().value > num ) {
                deque.removeLast();
            }
            //이후 새로운 노드 추가
            deque.addLast(new Node(num, i));
            //deque FI(First In)데이터가 window 를 벗어나면 삭제
            if(deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            //Buffered에 데이터 적재
            bw.write(deque.getFirst().value + " ");
        }
        //출력
        bw.flush();
        bw.close();
    }

    static class  Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
