package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14889 {
    public static long min = (int) 1e9;
    public static int n;
    public static int[][] map;

    public static long calc(int[] team) {
        long sum = 0;
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                sum += map[team[i]][team[j]];
                sum += map[team[j]][team[i]];
            }
        }
        return sum;
    }
    public static void dfs(boolean[] visited, int[] box, int start, int count){
        if (count == n / 2) {
            boolean[] team = new boolean[n];//전체 n
            for (int i = 0; i < box.length; i++) {
                team[box[i]] = true;
            }

            int[] other = new int [count];
            int idx=0;
            for (int i = 0; i < team.length; i++) {
                if(!team[i]) {
                    other[idx] = i;
                    idx++;
                }
            }

            long boxAns = calc(box);
            long otherAns = calc(other);
            long ans = boxAns - otherAns;
            min = Math.min(min, Math.abs(ans));
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                box[count] = i;
                dfs(visited, box, i, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[n];
        int[] box = new int[n / 2];
        dfs(visited, box, 0, 0);
        System.out.println(min);
    }
}
