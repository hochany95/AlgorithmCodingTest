package baekjoonAlgorithm;

import java.io.*;
import java.util.*;
public class baekjoon_1654 {

    public static long findAnsWithArrayList(ArrayList<Integer> arr, int target) {
        long l = 0;
        long r = arr.get(arr.size() - 1);
        long ans = 0;
        while (l <= r) {
            long mid = l + ((r-l)/2);
            long sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i) / mid;
            }
            if (sum >= target) {
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        System.out.println(findAnsWithArrayList(arr, m));
    }
}
