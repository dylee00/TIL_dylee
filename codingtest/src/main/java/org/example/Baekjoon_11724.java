package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_11724 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1]; //그래프 저장 arrayList -> 1번 인덱스부터 사용하기 위해 N+1
        visited = new boolean[N+1]; //방문 저장 배열

        //노드 저장
        for(int i = 1; i <= N; i++){
            A[i] = new ArrayList<Integer>();
        }

        //edge 저장
        for (int j = 0; j < E; j++) {
            st = new  StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            //양방향으로 저장
            A[s].add(t);
            A[t].add(s);
        }

        //방문 배열에 false가 있다면 dfs 수행
        int count = 0;
        //모든 노드 순회
        for (int i = 1; i <= N; i++) {
            //i node를 방문하지 않았다면 -> i노드 시작점으로 dfs순회
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int i){
        //이미 순회했으면 return
        if(!visited[i]) return;
        visited[i] = true;
        //A[i]의 안의 원소를 j에 저장한 다음 A[i]에 j를 저장할 수 없을 때까지(A[i])의 끝까지 순회
        for(int j :A[i]){
            if (visited[j] == false) {
                DFS(j);
            }
        }
    }

}
