package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1976 {

    public static int[] parent = new int[201];

    public static int findParent(int x) {
        if(parent[x] == x) return parent[x];
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(b < a) parent[a] = b;
        else parent[b] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        int[] ct = new int[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    union(findParent(i), findParent(j));
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ct[i] = Integer.parseInt(st.nextToken());
        }

        boolean ans = true;
        if (m > 1) {
            int prev = findParent(ct[0]);
            for (int i = 1; i < m; i++) {
                if(prev != findParent(ct[i])){
                    ans = false;
                    break;
                }
                prev = findParent(ct[i]);
            }
        }
        System.out.println(ans? "YES":"NO");
    }
}
