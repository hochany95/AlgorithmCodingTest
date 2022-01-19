package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon_16234 {

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int n, l, r;

    public static class City {
        private int row, col, people;

        public City(int row, int col, int people) {
            this.row = row;
            this.col = col;
            this.people = people;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getPeople() {
            return people;
        }
    }

    public static void dfs(int[][] map, boolean[][] visited, ArrayList<City> cList, int row, int col) {

        int now = map[row][col];

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                int diff = Math.abs(now - map[nr][nc]);
                if (!visited[nr][nc] && diff >= l && diff <= r) {
                    visited[nr][nc] = true;
                    cList.add(new City(nr, nc, map[nr][nc]));
                    dfs(map, visited, cList, nr, nc);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int moveCount = 0;

        while (true) {//한번 루프에 이동 완료
            ArrayList<ArrayList<City>> cities = new ArrayList<>();
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        ArrayList<City> temp = new ArrayList<>();
                        temp.add(new City(i, j, map[i][j]));


                        dfs(map, visited, temp, i, j);
                        if (temp.size() > 1) {
                            cities.add(temp);
                        }
                    }
                }
            }
            if (cities.size() > 0) {
                moveCount++;
                for (int i = 0; i < cities.size(); i++) {
                    int sum = 0;
                    int div = cities.get(i).size();
                    for (City c : cities.get(i)) {
                        sum += c.getPeople();
                    }
                    int nPeople = sum / div;
                    for (City c : cities.get(i)) {
                        map[c.getRow()][c.getCol()] = nPeople;
                    }
                }
            } else {//개방된 도시 없음
                break;
            }
        }
        System.out.println(moveCount);
    }
}
