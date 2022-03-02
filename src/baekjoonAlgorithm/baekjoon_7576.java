package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_7576 {

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static class Position{
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean fin(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        Queue<Position> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new Position(i, j));
                }
            }
        }
        int ans = 0;

        while (true) {
            Queue<Position> nq = new LinkedList<>();
            if(fin(map)) break;
            if(q.isEmpty()) {
                ans = -1;
                break;
            }

            ans++;

            while (!q.isEmpty()) {
                Position p = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                    if (map[nr][nc] == 0) {
                        nq.offer(new Position(nr, nc));
                        map[nr][nc] = 1;
                    }
                }
            }
//            while (!nq.isEmpty()) {
//                q.offer(nq.poll());
//            }
            q = nq;
        }
        System.out.println(ans);
    }
}
