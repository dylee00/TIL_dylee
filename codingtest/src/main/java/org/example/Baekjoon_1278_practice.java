package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1278_practice {
    //상하좌우 탐색을 위한 dx,dy
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0, -1, 0};
    //x -> 0, y -> 1 은 아래(하)탐색
    //x -> 1, y -> 0 은 오른쪽 탐색
    //x -> 0, y -> -1 은 위 탐색
    //x -> -1, y -> 0 은 왼쪽 탐색
    static boolean[][] visited;
    static int [][] A;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int [N][M];
        visited = new boolean[N][M];

        //데이터 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            //input에 공백이 없으니 nextToken대신 String으로
            String line = st.nextToken();
            for(int j = 0; j < M; j++){
                //j부터 j+1까지 string을 짤라서 Integer로 변경
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); //queue에 시작 index 넣기
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); //queue에서 방문할 노드의 index 빼기
            visited[i][j] = true;
            //상하좌우 탐색
            for (int k = 0; k < 4; k++) {
                //상하좌우 탐색 위한 define으로 좌표 update
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //좌표 유효성 검사
                if (x >= 0 && y >= 0 && x < N && y < M) { //배열의 범위를 넘어가면 안되고
                    if (A[x][y] != 0 && !visited[x][y]) { //0이어도 안되고 이미 방문한 배열이어도 안됨
                        //탐색 가능
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //depth + 1 update
                        queue.add(new int[] {x, y}); //다음 탐색 값 update
                    }
                }
            }
        }
    }
}
