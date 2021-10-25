package algorithm.baekjoon;
import java.util.*;
public class baekjoon_13410 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=1; i<=m; i++){

            StringBuilder temp = new StringBuilder(Integer.toString(n*i));
            arr.add(Integer.parseInt(temp.reverse().toString()));
        }
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr.get(0));

    }
}
