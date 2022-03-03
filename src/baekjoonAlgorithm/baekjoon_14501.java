package baekjoonAlgorithm;

import java.util.*;

public class baekjoon_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[15];
        int[] pay = new int[15];
        int[] dp = new int[16];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            int t = time[i] + i;
            // 상담이 기간 안에 끝나는 경우
            if (t <= n) {
                // 점화식에 맞게, 현재까지의 최고 이익 계산

                dp[i] = Math.max(pay[i] + dp[t], maxValue);
//                System.out.println(i + " " + pay[i] + " " + dp[t] + " " + maxValue + " " + dp[i]);
                maxValue = dp[i];
            }
            // 상담이 기간을 벗어나는 경우
            else dp[i] = maxValue;
        }

        System.out.println(maxValue);


    }
}
