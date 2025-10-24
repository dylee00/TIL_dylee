import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph; //방향이 없는 그래프 저장하는 ArrayList
    static boolean[] visited; //그래프 방문 배열
    static int[] check; //노드 집합 체크 배열
    static boolean isGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        for (int t = 0; t < testCase; t++) {
            
        //이분그래프 true/false
        isGraph = true;   
            
        //V,E를 입력받고 그래프를 저장할 ArrayList, 방문배열, 집합배열 생성
        st =  new StringTokenizer(br.readLine());
        int V,E;
        V = Integer.parseInt(st.nextToken(" "));
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        check = new int[V+1];

        //리스트 초기화
        for (int p = 1; p <= V; p++) {
            graph[p] = new ArrayList<Integer>();
        }

        //엣지들을 인접 리스트에 저장
        for (int j = 0; j < E; j++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken(" "));
            int edge = Integer.parseInt(st.nextToken());
            //방향이 없는 그래프 -> 양방향으로 저장
            graph[node].add(edge);
            graph[edge].add(node);
        }


        //그래프를 DFS로 탐색
            for (int i = 1; i <= V; i++) {
                if (isGraph) {
                    DFS(i);
                } else {
                    break;
                }
            }

            if (isGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
    public static void DFS(int start) {
        visited[start] = true;
        //start와 연결된 모든 노드 탐색
        for(int next: graph[start]){
            if (!visited[next]) {
                check[next] = (check[start] + 1) % 2;
                DFS(next);
            } else {
                if (check[start] == check[next]) {
                    isGraph = false;
                }
            }
        }

    }

}