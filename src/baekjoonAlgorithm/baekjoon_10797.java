package baekjoonAlgorithm;
import java.util.*;
public class baekjoon_10797 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i=0; i<5; i++){
            if(n == sc.nextInt())
                count++;
        }
        System.out.println(count);
    }
}
