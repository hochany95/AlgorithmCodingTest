package baekjoonAlgorithm;

import java.io.*;
import java.util.Arrays;

public class baekjoon_2805 {
    public static long findAns(int[] arr, long target) {
        int l = 0;
        int r = arr[arr.length - 1];
        long ans = -1;
        while (l <= r) {
            int mid = l + ((r-l)/2);
            long sum = 0;
            for(int i=0; i<arr.length; i++){
                long t = arr[i] - mid;
                sum += t>0? t:0;
            }
            if(sum >=target){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] lenInput = br.readLine().split(" ");
        int[] lens = new int[n];
        for (int i = 0; i < lenInput.length; i++) {
            lens[i] = Integer.parseInt(lenInput[i]);
        }

        Arrays.sort(lens);
        System.out.println(findAns(lens, m));
    }
}
