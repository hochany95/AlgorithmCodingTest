package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_2110 {
    public static int getCount(int[] arr, int d){
        int count = 1;
        int now = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] - now >= d){
                now = arr[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int start = 0;
        int end = arr[n-1];
        int ans = -1;
        while(start<end){
            int mid = (start + end) / 2;

            if(getCount(arr, mid) >= c){
                ans = mid;
                start = mid+1;
            }
            else
                end = mid;
        }
        System.out.println(ans);
    }
}
