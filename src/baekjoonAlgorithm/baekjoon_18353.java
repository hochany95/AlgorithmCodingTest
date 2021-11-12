package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_18353 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] man = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            man[i] = sc.nextInt();
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++)
            for(int j=0; j<i; j++)
                if(man[j]>man[i] && dp[j]>=dp[i])
                    dp[i] = dp[j]+1;
        int max = 0;
        for(int i=0; i<n; i++)
            if(max<dp[i])
                max = dp[i];
        System.out.println(n-max);
    }
}
