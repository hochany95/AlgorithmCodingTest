package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_2953 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = 0, now = 0, ans = 0;
        for(int i=0; i<5; i++){
            now = 0;
            for(int j=0; j<4; j++){
                now += sc.nextInt();
                if(now>max){
                    max = now;
                    ans = i+1;
                }
            }
        }
        System.out.println(ans+" "+max);
    }
}
