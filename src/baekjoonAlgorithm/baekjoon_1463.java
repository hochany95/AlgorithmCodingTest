package baekjoonAlgorithm;

import java.util.*;

public class baekjoon_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1000001];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        int n = sc.nextInt();
        if (n <= 3) System.out.println(arr[n]);
        else {
            for (int i = 4; i <= n; i++) {
                if (i % 6 == 0)
                    arr[i] = Math.min(arr[i / 3] + 1, arr[i / 2] + 1);
                else if (i % 3 == 0)
                    arr[i] = Math.min(arr[i / 3] + 1, arr[i-1] + 1);
                else if (i % 2 == 0)
                    arr[i] = Math.min(arr[i / 2] + 1, arr[i-1] + 1);
                else
                    arr[i] = arr[i - 1] + 1;
            }
            System.out.println(arr[n]);
        }
    }
}
