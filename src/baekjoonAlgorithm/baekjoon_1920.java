package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1920 {
    public static boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return true;
            if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> inputArr = new ArrayList<>();
        for(int i=0; i<n; i++)
            inputArr.add(sc.nextInt());
        Collections.sort(inputArr);
        int[] arr = new int[n];
        for(int i=0; i<inputArr.size(); i++)
            arr[i] = inputArr.get(i);

        int m = sc.nextInt();
        for(int i=0; i<m; i++)
            System.out.println(binarySearch(arr, sc.nextInt())? 1 : 0);

    }
}
