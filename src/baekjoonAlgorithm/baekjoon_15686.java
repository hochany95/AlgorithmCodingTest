package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_15686 {


    public static ArrayList<ArrayList<Integer>> order = new ArrayList<>();
    public static int min = (int) 1e9;
    public static class Position{
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void comb(int[] box, boolean[] visited, int n, int r,int start, int depth){
        if(depth == r){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                temp.add(box[i]);
            }
            order.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                box[depth] = i;
                comb(box, visited, n, r, i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calc(int r, int c, int x, int y) {
        return Math.abs(r - x) + Math.abs(c - y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Position> home = new ArrayList<>();
        ArrayList<Position> chicken = new ArrayList<>();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new Position(i, j));
                if(map[i][j] == 2)chicken.add(new Position(i, j));
            }
        }
        int[] box = new int[m];
        boolean[] visited = new boolean[chicken.size()];
        comb(box, visited, chicken.size(), m, 0, 0);

        int sum, dist;
        for (int i = 0; i < order.size(); i++) {
            sum = 0;
            for (int j = 0; j < home.size(); j++) {
                dist = n * n;
                Position h = home.get(j);
                for (int k = 0; k < m; k++) {
                    Position c = chicken.get(order.get(i).get(k));
                    dist = Math.min(dist, calc(h.r, h.c, c.r, c.c));
                }
                sum += dist;
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}
