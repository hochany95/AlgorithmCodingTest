package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_13305 {

    public static long min;
    public static void main(String[] args) throws IOException {
        long ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }


        min = price[0];
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += dist[i - 1];
            if (price[i] < min || i == n-1) {
                ans += sum * min;
                min = price[i];
                sum = 0;
            }
        }
        System.out.println(ans);
    }
}
