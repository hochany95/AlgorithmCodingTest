package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_1012 {

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int n, m;

    static class Position {
        private int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public static void checkWorm(int[][] map, int r, int c) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(r, c));

        while (!q.isEmpty()) {
            Position p = q.poll();

            int row = p.getRow();
            int col = p.getCol();

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1){
                    q.offer(new Position(nr, nc));
                    map[nr][nc] = 2;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        ans++;
                        checkWorm(map, i, j);
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
