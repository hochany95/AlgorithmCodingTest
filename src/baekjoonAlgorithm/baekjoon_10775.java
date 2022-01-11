package baekjoonAlgorithm;

import java.io.*;

public class baekjoon_10775 {
    public static int findParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }

    public static void union(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) {
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int[] arr = new int[m];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            int p = findParent(parent, arr[i]);
            if(p == 0) break;
            union(parent, p, p-1);
            ans++;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.close();

    }
}
