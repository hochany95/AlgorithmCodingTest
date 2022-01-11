package baekjoonAlgorithm;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (m / arr[i] > 0) {
                ans += m / arr[i];
                m %= arr[i];
            }
        }
        bw.write(Integer.toString(ans));

        br.close();
        bw.close();
    }
}
