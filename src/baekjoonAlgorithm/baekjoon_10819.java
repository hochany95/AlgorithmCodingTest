package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10819 {
    public static long max = 0;

    public static long calc(int[] map, int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(map[arr[i]] - map[arr[i + 1]]);
        }
        return sum;
    }

    public static void dfs(int[] map,  int[] box, boolean[] visited, int n, int count) {
        if (count == n) {
            long ans = calc(map, box);
            max = Math.max(max, ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                box[count] = i;
                dfs(map, box, visited, n, count + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] box = new int[n];
        boolean[] visited = new boolean[n];

        dfs(arr, box, visited, n, 0);
        System.out.println(max);
    }
}
