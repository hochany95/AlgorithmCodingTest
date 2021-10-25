package baekjoon;
import java.util.*;
public class baekjoon_14720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int next = 0, count = 0;

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] == next){
                next = (next+1 == 3)? 0 : next+1;
                count++;
            }
        }
        System.out.println(count);
    }
}
