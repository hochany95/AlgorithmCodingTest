package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_11720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();
        int total = 0;
        for(int i=0; i<n; i++)
            total += line.charAt(i) - '0';
        System.out.println(total);
    }
}
