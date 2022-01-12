package baekjoonAlgorithm;

import java.io.*;
import java.util.Arrays;

public class baekjoon_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);
        int ans = num[n-1];
        int min = num[n-1];
        int count = 1;
        if(n > 1){
            for (int i = n - 2; i >= 0; i--) {
                min = num[i];
                count++;
                ans = Math.max(ans, min*count);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
