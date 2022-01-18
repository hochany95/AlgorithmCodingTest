package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_14888 {

    public static int max = (int) -1e9;
    public static int min = (int) 1e9;
    public static int n;

    public static int calc(int a, int b, int idx) {
        if (idx == 0) return a + b;
        if (idx == 1) return a - b;
        if (idx == 2) return a * b;
        if (idx == 3) return a / b;
        return 0;
    }

    public static int back(int a, int b, int idx) {
        if (idx == 0) return a - b;
        if (idx == 1) return a + b;
        if (idx == 2) return a / b;
        if (idx == 3) return a * b;
        return 0;
    }

    public static void dfs(int[] arr, int[] operator, int idx, int ans) {
        if (idx == n) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                ans = calc(ans, arr[idx], i);
                dfs(arr, operator, idx + 1, ans);
                operator[i]++;
                ans = back(ans, arr[idx], i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        int ans = arr[0];
        dfs(arr, operator, 1, ans);
        System.out.println(max);
        System.out.println(min);
    }
}
