package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[n][12];
        for (int i = 2; i <= 10; i++) {//1~10 -> 0~9
            d[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 10; j++) {
                d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % (int) 1e9;
                // 덧셈 과정에서 overflow 발생, 매 결과마다 div 1e9 필요
            }
        }
        long sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println(d[n - 1][i]);
            sum = (sum + d[n - 1][i]) % (int) 1e9;
        }
        System.out.println(sum);
    }
}
