import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      //D[N] = D[N-1] + D[N-2]
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long rectangle[] = new long[1001];
        rectangle[1] = 1;
        rectangle[2] = 2;
        for (int i = 3; i <= N; i++) {
            rectangle[i] = (rectangle[i - 1] + rectangle[i - 2]) % 10007;
        }
        System.out.println(rectangle[N]);
    }
}