package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class baekjoon_2110 {
    public static int findCount(int[] arr, int target) {
        int start = 1;//최소 간격
        int end = arr[arr.length-1] - arr[0];//범위 최대
        int count;
        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int now = arr[0] + mid;
            int idx = 1;

            count = 1;
            while (idx < arr.length) {
                if (arr[idx] >= now) {
                    count++;
                    now = arr[idx] + mid;
                }
                idx++;
            }
            if (count >= target) {//
                ans = mid;
                start = mid+1;

            } else {
                end = mid -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(findCount(arr, c));
    }
}
