package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class baekjoon_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger[] d = new BigInteger[30];
        //factorial의 큰 값을 위한 BigInteger 클래스 사용
        d[0] = BigInteger.ONE;
        d[1] = BigInteger.ONE;
        for (int i = 2; i < 30; i++) {
            BigInteger mul = new BigInteger(Integer.toString(i));
            d[i] = d[i-1].multiply(mul);
        }
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            BigInteger c = d[b].divide(d[a].multiply(d[b-a]));
            sb.append(c + "\n");
        }
        System.out.println(sb.toString());
    }
}
