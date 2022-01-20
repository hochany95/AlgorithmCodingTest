package baekjoonAlgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_10816 {

    public static int findLeft(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static int findRight(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    public static int findCount(int[] card, int target) {
        return findRight(card, target) - findLeft(card, target);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < m; i++) {
            bw.write(findCount(card, arr[i])+" ");
        }
        bw.flush();
    }
}
