import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int room[][];
    static int status; //0북 1동 2남 3서
    static int N;
    static int M;
    static int score = 0;

    //북 동 남 서 (row,col)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); //row
        int y = Integer.parseInt(st.nextToken()); //col
        status = Integer.parseInt(st.nextToken());

        //room 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로봇청소기 작동
        cleanRoom(x, y);
        System.out.println(score);

    }
    public static void cleanRoom(int x, int y) {
        while (true) {
            //1. 현재 칸 청소
            if (room[x][y] == 0) {
                room[x][y] = 2;
                score++;
            }

            //2. 주변에 청소 안 된 칸이 있는지 확인
            boolean cleaned = false;
            for(int i = 0; i < 4; i++) {
                //반시계 방향 회전
                status = (status + 3) % 4;
                int nx = x + dx[status];
                int ny = y + dy[status];

                if(room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    cleaned = true;
                    break;
                }
            }

            //3. 4방향 다 확인 -> 0(청소 x) 못찾았다면 후진
            if(!cleaned) {
                int back = (status + 2) % 4; //후진 index 구하기
                int bx = x + dx[back];
                int by = y + dy[back];

                if (room[bx][by] == 1) {
                    return;
                } else {
                    x = bx;
                    y = by;
                }
            }
        }
    }
}