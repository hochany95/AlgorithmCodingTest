package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2667 {

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int count;

    public static class Home{
        private int row, col;

        public Home(int row, int col) {
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

    public static void dfs(int[][] map, boolean[][] visited, int r, int c) {
        int n = map.length;

        Queue<Home> q = new LinkedList<>();
        q.offer(new Home(r, c));
        while (!q.isEmpty()) {
            Home h = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = h.getRow() + dr[i];
                int nc = h.getCol() + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (!visited[nr][nc] && map[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        count++;
                        q.offer(new Home(nr, nc));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[n][n];
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    count = 1;
                    dfs(map, visited, i, j);
                    ans.add(count);
                }
            }
        }

        Collections.sort(ans);
        bw.write(ans.size()+"\n");
        for (int i = 0; i < ans.size(); i++) {
            bw.write(ans.get(i) + "\n");
        }
        bw.flush();
    }
}
