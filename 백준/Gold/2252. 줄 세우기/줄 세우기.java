import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>(); //노드저장배열
        for(int i=0;i<=N;i++) {
            nodeList.add(new ArrayList<>());
        }
        int inDegree[] = new int[N + 1]; //진입차수 저장
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            nodeList.get(S).add(E); //S -> E 저장
            inDegree[E]++; //진입차수 배열 데이터 저장
        }

        //위상정렬 실행
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            if(inDegree[i]==0) {  //해당 노드를 바라보는 edge가 없음
                queue.offer(i);
            }
        }
        //queue가 빌 때까지 반복
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            //queue에서 나온 index가 가리키는 노드가 존재한다면
            for(int next : nodeList.get(now)) {
                inDegree[next]--;
                if(inDegree[next]==0) {
                    queue.offer(next);
                }
            }
        }
    }
}