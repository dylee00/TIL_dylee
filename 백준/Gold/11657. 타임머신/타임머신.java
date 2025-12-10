import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Edge> edges = new ArrayList<>();
        long distance[] = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);  
        distance[1] = 0;
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, time));
        }
        
        // 벨만-포드 수행
        for (int i = 1; i < N; i++) {
            for(Edge edge: edges){
                if(distance[edge.start] != Integer.MAX_VALUE &&  
                   distance[edge.end] > distance[edge.start] + edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        
        // 음수 사이클 검출
        boolean cycle = false;
        for(Edge edge: edges){
            if(distance[edge.start] != Integer.MAX_VALUE &&  
               distance[edge.end] > distance[edge.start] + edge.time){
                cycle = true;
                break;
            }
        }
        
        if(!cycle){
            for (int i = 2; i <= N; i++) {  
                if (distance[i] == Integer.MAX_VALUE) {  
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}

class Edge{
    int start,end,time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}