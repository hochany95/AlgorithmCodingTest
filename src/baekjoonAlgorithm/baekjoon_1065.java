package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        loop:
        for(int i=1; i<=n; i++){
            String num = Integer.toString(i);
            if(num.length()<3) count++;
            else{
                for(int j=0; j<num.length()-2; j++){
                    if(num.charAt(j) - num.charAt(j+1) != num.charAt(j+1) - num.charAt(j+2))
                        continue loop;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
