package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n];
        d[0] = arr[0];
        if (n > 1) {
            d[1] = arr[0] + arr[1];
        }
        if (n > 2) {
            d[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        }


        for (int i = 3; i < n; i++) {
            d[i] = Math.max(d[i - 3] + arr[i - 1], d[i - 2]) + arr[i];
        }
        System.out.println(d[n - 1]);
        br.close();

    }
}
