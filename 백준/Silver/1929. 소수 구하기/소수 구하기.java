import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간 초과 문제 발생..
public class Main {
    static int Arr[];
    static boolean[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Arr = new int[M + 1]; //M번째 인덱스 = M이 되도록 배열 생성
        S = new boolean[M + 1]; //상태 배열 -> t면 소수 f면 소수 아님
        //state 배열 초기값 true로 초기화
        Arrays.fill(S, true);
        //배열에 0~M 까지 숫자 저장
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = i;
        }

        //에라스테노스의 체 사용해서 소수 구하기
        for(int i=1;i<Arr.length;i++){
            int num = Arr[i];
            boolean state = S[i];
            //num > 1 이고 state = true라면
            if (num > 1 && state) {
                changeState(num);
            } else {
                S[num] = false;
            }
        }

        //출력
        for (int i = N; i < S.length; i++) {
            if (S[i]) {
                System.out.println(i);
            }
        }
    }

    //num 배수 상태 배열을 false로 변경
    private static void changeState(int num) {
        for(int j=num*2;j<Arr.length;j=j+num){
            //Arr[j]기 num의 배수고 state = true라면 false로 바꾸기
            boolean state = S[j];
            if (state) {
                int s = Arr[j]%num;
                if (s == 0) {
                    S[j] = false;
                }
            }
        }
    }
}
