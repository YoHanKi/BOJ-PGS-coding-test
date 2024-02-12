import java.io.*;

public class Main {
    static int[] arr, tmpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        tmpArr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge(1,N);

        //출력
        for (int i = 1; i <= N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge(int start, int end) {
        if(end - start < 1) return;
        //평균을 구하고, start만큼 더해 중간 인덱스를 구한다.
        int middle = ((end - start) / 2) + start;
        //재귀 함수로 합병 정렬 구현
        merge(start,middle);
        //middle 기준 전후로 나눈다.
        merge(middle+1,end);
        //tmp에 배열 복사
        for (int i = start; i <= end; i++) {
            tmpArr[i] = arr[i];
        }
        //두 그룹을 병합(투 포인터 알고리즘)
        int k = start;
        int index1 = start;
        int index2 = middle + 1;
        //첫번째 포인터가 그룹의 끝(middle)에 있고, 두번째 포인터가 그룹의 끝(end)에 있으면 종료
        while (index1 <= middle && index2 <= end) {
            //만약 index2 포인터가 더 작다면 포인터 이동 및 적재
            if(tmpArr[index1] > tmpArr[index2]) {
                arr[k] = tmpArr[index2];
                k++;
                index2++;
                //만약 index1 포인터가 더 작다면 포인터 이동 및 적재
            } else {
                arr[k] = tmpArr[index1];
                k++;
                index1++;
            }
        }
        //남아있는 인덱스를 정리
        //만약 그룹 1이 남아있다면 나머지 적재
        while (index1 <= middle) {
            arr[k] = tmpArr[index1];
            k++;
            index1++;
        }
        //만약 그룹 2가 남아있다면 나머지 적재
        while (index2 <= end) {
            arr[k] = tmpArr[index2];
            k++;
            index2++;
        }
    }
}