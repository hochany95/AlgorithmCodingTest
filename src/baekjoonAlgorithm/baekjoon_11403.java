package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11403 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()) > 0 ? 1 : INF;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(graph[i][0] < INF ? 1 : 0);
            for (int j = 1; j < n; j++) {
                System.out.print(graph[i][j] < INF ? " " + 1 : " " + 0);
            }
            System.out.println();
        }
    }
}
