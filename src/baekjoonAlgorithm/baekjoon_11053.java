package baekjoonAlgorithm;

import java.util.*;

public class baekjoon_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dy[i] = 1;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i] && dy[j] >= dy[i])
                    dy[i] = dy[j] + 1;

        int max = 0;
        for (int i = 0; i < dy.length; i++) {
            if (dy[i] > max)
                max = dy[i];
        }
        System.out.println(max);


    }
}
