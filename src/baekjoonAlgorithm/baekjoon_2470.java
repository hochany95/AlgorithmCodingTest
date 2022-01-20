package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        int ansL = 0;
        int ansR = n - 1;
        int compare = Integer.MAX_VALUE;
        while (l < r) {
            int now = arr[l] + arr[r];
            if (Math.abs(now) <= Math.abs(compare)) {
                compare = now;
                ansL = l;
                ansR = r;
            }
            if (now > 0) {
                r--;
            } else if (now < 0) {
                l++;
            } else {
                ansL = l;
                ansR = r;
                break;
            }
        }
        System.out.println(arr[ansL] + " " + arr[ansR]);
    }
}
