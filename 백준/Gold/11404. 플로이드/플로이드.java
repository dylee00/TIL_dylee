import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        //costs 배열 생성, 초기화
        int costs[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                } else {
                    costs[i][j] = INF;
                }
            }
        }

        //cost 넣기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //문제를 보니, 중간에 cost가 갱신되는 경우가 있음 -> 이 case에 대한 처리 필요
            if(costs[start][end] > cost) {
                costs[start][end] = cost;
            }
        }

        //플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                if(costs[s][k] == INF) continue;
                for(int e = 1; e<=n; e++) {
                    if(costs[k][e] == INF) continue;
                    if (costs[s][e] > costs[s][k] + costs[k][e]) {
                        costs[s][e] = costs[s][k] + costs[k][e];
                    }
                }
            }
        }

        //결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(costs[i][j] == INF) {
                    System.out.print(0 + " ");
                }else  {
                    System.out.print(costs[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}