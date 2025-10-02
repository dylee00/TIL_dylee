package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1278 {
    //상하좌우 탐색 위한 배열 선언
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited; //방문배열
    static int[][] Arr; //배열
    static int N, M;
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                Arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        System.out.println(Arr[N-1][M-1]);

    }
    private static void BFS(int x, int y) {
        //queue에 입력받은 좌표를 넣고, queue가 빌 때까지 순회
        Queue<int[]> queue = new LinkedList<>(); //queue에 배열 형태로 원소 삽입
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[now[0]][now[1]] = true;
            //상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(Arr[nx][ny] != 0 && !visited[nx][ny]) { //방문할 수 있는 칸이고, 방문 배열에 없다면
                        visited[nx][ny] = true; //방문 배열 update
                        Arr[nx][ny] = Arr[nx][ny] + 1; //depth update
                        queue.offer(new int[]{nx, ny}); //queue에 탐색 대상으로 추가
                    }
                }
            }
        }

    }
}
