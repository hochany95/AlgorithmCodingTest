package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1987 {

    public static int max = 0;

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static void dfs(char[][] arr, boolean[] visited, int r, int c, int count) {
        if(count > max) max = count;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= arr.length || nc >= arr[0].length) {
                continue;
            }else{
                if(!visited[(int)arr[nr][nc]-'A']){
                    visited[(int) arr[nr][nc]-'A'] = true;
                    dfs(arr, visited, nr, nc, count + 1);
                    visited[(int) arr[nr][nc]-'A'] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String chars = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars.charAt(j);
            }
        }
        boolean[] visited = new boolean[27];
        visited[(int) arr[0][0] - 'A'] = true;
        dfs(arr, visited, 0, 0, 1);
        System.out.println(max);
    }
}
