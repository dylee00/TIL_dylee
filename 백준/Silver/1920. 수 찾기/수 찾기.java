import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N개의 정수를 받아 배열에 저장
        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(A);
        //부분 탐색으로 M번 탐색하며 input으로 받은 숫자를 A에서 찾기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int such =  Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            boolean status = false;
            while(start <= end){
                int mid = (start + end)/2;
                if (A[mid] == such) {
                    status = true;
                    break;
                } else if (A[mid] > such) {
                    end = mid - 1;
                } else if(A[mid] < such) {
                    start = mid + 1;
                }
            }
            if(status){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}