package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_14502 {


    static class Position {
        private int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }

    public static int max = -1;
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};


    public static void check(int[][] map) {
        ArrayList<Position> vList = new ArrayList<>();
        int n = map.length;
        int m = map[0].length;
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][j];
            }
        }// 임시 맴 생성

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    vList.add(new Position(i, j));
                }
            }
        }//바이러스 리스트 작성
        for (int i = 0; i < vList.size(); i++) {
            Position p = vList.get(i);
            virus(temp, p.getR(), p.getC());
        }
        max = Math.max(max, getScore(temp));
    }

    public static void virus(int[][] temp, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < temp.length && nc >= 0 && nc < temp[0].length && temp[nr][nc] == 0) {
                temp[nr][nc] = 2;
                virus(temp, nr, nc);
            }
        }
    }

    public static int getScore(int[][] temp) {
        int n = temp.length;
        int m = temp[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n * m; i++) {
            if (map[i / m][i % m] != 0) continue;
            map[i / m][i % m] = 1;
            for (int j = i + 1; j < n * m; j++) {
                if (map[j / m][j % m] != 0) continue;
                map[j / m][j % m] = 1;
                for (int k = j + 1; k < n * m; k++) {
                    if (map[k / m][k % m] != 0) continue;
                    map[k / m][k % m] = 1;
                    check(map);
                    map[k / m][k % m] = 0;
                }
                map[j / m][j % m] = 0;
            }
            map[i / m][i % m] = 0;
        }
        System.out.println(max);
    }
}
