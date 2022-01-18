package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_18405 {

    public static PriorityQueue<Position> pq = new PriorityQueue<>();
    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};

    static class Position implements Comparable<Position> {
        private int r;
        private int c;
        private int index;

        public Position(int r, int c, int index) {
            this.r = r;
            this.c = c;
            this.index = index;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Position o) {
            return Integer.compare(this.index, o.index);
        }
    }

    public static void virus(int[][] map) {
        int n = map.length;
        ArrayList<Position> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
            Position p = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p.getR() + dr[i];
                int nc = p.getC() + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                    map[nr][nc] = p.getIndex();
                    temp.add(new Position(nr, nc, p.getIndex()));
                }
            }
        }
        for(int i=0; i<temp.size(); i++){
            pq.offer(temp.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    pq.offer(new Position(i, j, map[i][j]));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            virus(map);
            if(map[r-1][c-1] > 0) continue;
        }

        bw.write(Integer.toString(map[r-1][c-1]));
        bw.flush();
    }
}
