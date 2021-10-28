package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1439 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] count = new int[2];
        char current = input.charAt(0);
        count[current - '0']++;
        for(int i=1; i<input.length(); i++){
            char now = input.charAt(i);
            if(now != current){
                current = now;
                count[current - '0']++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}
