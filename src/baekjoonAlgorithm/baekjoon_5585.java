package baekjoonAlgorithm;

import java.io.*;

public class baekjoon_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1000 - Integer.parseInt(br.readLine());
        int[] m = {500, 100, 50, 10, 5, 1};
        int ans = 0;
        for (int i = 0; i < m.length; i++) {
            ans += n / m[i];
            n %= m[i];
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
