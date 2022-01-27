package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 6; i < 101; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}
