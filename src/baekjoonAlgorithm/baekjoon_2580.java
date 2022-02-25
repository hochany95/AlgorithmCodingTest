package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_2580 {

    public static StringBuilder sb = new StringBuilder();
    public static boolean possible(int[][] map, int r, int c, int value) {
        for (int i = 0; i < 9; i++) {
            if (i == c) continue;
            if (map[r][i] == value) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == r) continue;
            if (map[i][c] == value) return false;
        }

        int nr = r / 3;
        int nc = c / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nr * 3 + i == r && nc * 3 + j == c) continue;
                if (map[nr * 3 + i][nc * 3 + j] == value) return false;
            }
        }
        return true;
    }

    public static void dfs(ArrayList<Integer[]> empty, int[][] map, int count) {
        if (count == empty.size()) {
            if (sb.length() == 0) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(map[i][j] + " ");
                    }
                    sb.append("\n");
                }
            }
            return;
        }

        int r = empty.get(count)[0];
        int c = empty.get(count)[1];

        for (int i = 1; i <= 9; i++) {
            map[r][c] = i;
            if (possible(map, r, c, i)) {
                dfs(empty, map, count + 1);
            }
            map[r][c] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer[]> empty = new ArrayList<>();
        int[][] map = new int[9][9];

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    Integer[] z = {i, j};
                    empty.add(z);
                }
            }
        }
        dfs(empty, map, 0);
        System.out.println(sb);
    }
}
