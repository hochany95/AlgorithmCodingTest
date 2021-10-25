package baekjoonAlgorithm;
import java.util.*;
public class baekjoon_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[5001];
        Arrays.fill(arr, 5000);
        arr[3] = 1;
        arr[5] = 1;
        if(n>5){
            for(int i=6; i<=n; i++){
                arr[i] = Math.min(arr[i-3]+1, arr[i-5]+1);
            }
        }
        System.out.println((arr[n]>=5000)? -1 : arr[n]);
    }
}
