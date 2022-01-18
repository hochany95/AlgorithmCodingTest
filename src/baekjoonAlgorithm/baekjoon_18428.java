package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_18428 {

    public static int n;
    public static boolean possible;

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static ArrayList<Position> tList = new ArrayList<>();

    public static class Position{
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

    public static boolean checkDirection(String[][] map, Position p, int d) {
        int n = map.length;

        int r = p.getR();
        int c = p.getC();
        int nr = r;
        int nc = c;

        while (true) {
            nr = nr + dr[d];
            nc = nc + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                return true;
            }
            if(map[nr][nc].equals("S"))
                return false;
            if (map[nr][nc].equals("O")) {
                return true;
            }
        }
    }

    public static boolean isPossible (String[][] map) {

        boolean ans = true;
        for (int i = 0; i < tList.size(); i++) {
            Position p = tList.get(i);//교사마다 확인인

            for (int j = 0; j < 4; j++) {
                if (!checkDirection(map, p, j)) {
                    ans = false;
                }
            }
        }
        return ans;

    }
    public static void dfs(String[][] map, int count) {
        if (count == 3) {
            if(isPossible(map))
                possible = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j].equals("X")){
                    map[i][j] = "O";
                    count += 1;
                    dfs(map, count);
                    count -=1;
                    map[i][j] = "X";
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("T")) {
                    tList.add(new Position(i, j));
                }
            }
        }

        dfs(map, 0);
        System.out.println(possible ? "YES" : "NO");
    }
}
