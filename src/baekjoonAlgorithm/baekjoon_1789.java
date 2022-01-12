package baekjoonAlgorithm;

import java.io.*;

public class baekjoon_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        int i = 1;
        int ans = 0;
        while (true) {
            if (n - i >= 0) {
                ans++;
                n -= i++;
            }else{
                break;
            }
        }
        bw.write(Long.toString(ans));

        bw.flush();
        br.close();
        bw.close();
    }
}
