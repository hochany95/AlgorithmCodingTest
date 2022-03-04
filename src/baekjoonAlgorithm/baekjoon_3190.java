package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_3190 {

    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};//오 아래 왼 위

    public static class Position {
        int r, c, d;

        public Position(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static class Turn {
        int time;
        char direction;

        public Turn(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        boolean[][] body = new boolean[n + 1][n + 1];

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {//사과 정보
            st = new StringTokenizer(br.readLine());
            int ar = Integer.parseInt(st.nextToken());
            int ac = Integer.parseInt(st.nextToken());
            map[ar][ac] = -1;//사과 존재
        }

        int l = Integer.parseInt(br.readLine());//방향 전환 정보
        Queue<Turn> q = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            q.offer(new Turn(t, d));
        }
        Position head = new Position(1, 1, 0);
        Position tail = new Position(1, 1, 0);//방향은 무의미

        body[1][1] = true;//현 위치
        map[1][1] = 0;
        int time = 0;
        Turn nowTurn = q.poll();
        int nowT = nowTurn.time;
        char nowD = nowTurn.direction;
        boolean isApple = false;

        while (true) {
            time++;

            int nr = head.r + dr[head.d];
            int nc = head.c + dc[head.d];

            if (nr < 1 || nc < 1 || nr > n || nc > n) break;//벽에 충동
            if (body[nr][nc]) break;//자기 몸과 충돌

            //충돌하지 않았으면 전진
            head.r = nr;
            head.c = nc;
            body[nr][nc] = true;

            // 사과가 있는지 확인.  이후 꼬리 관리
            if (map[nr][nc] == -1) {
                map[nr][nc] = 0;
                isApple = true;
            }

            //방향 전환이 필요한 경우 헤드의 방향 전환
            if (time == nowT) {
                if (nowD == 'D') {
                    head.d = (head.d + 1) % 4;
                } else if (nowD == 'L') {
                    head.d = head.d - 1 < 0 ? 3 : head.d - 1;
                }

                if (!q.isEmpty()) {// 다음 순서로
                    nowTurn = q.poll();
                    nowT = nowTurn.time;
                    nowD = nowTurn.direction;
                }
            }

            map[nr][nc] = head.d;//현재 위치에 방향 표시

            //꼬리 관리
            if (isApple) {//사과가 있는 경우
                isApple = false;
            } else {//없는 경우
                int nd = map[tail.r][tail.c];
                body[tail.r][tail.c] = false;
                tail.r = tail.r + dr[nd];
                tail.c = tail.c + dc[nd];
            }
        }
        System.out.println(time);
    }
}
