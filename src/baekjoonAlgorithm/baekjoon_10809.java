package baekjoonAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_10809 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] alphaIdx = new int[alpha.length()];
        Arrays.fill(alphaIdx, -1);
        for(int i=0; i<input.length(); i++){
            int idx = input.charAt(i) - 'a';
            if(alphaIdx[idx] == -1){
                alphaIdx[idx] = i;
            }
        }
        System.out.print(alphaIdx[0]);
        for(int i=1; i< alphaIdx.length; i++) System.out.print(" "+alphaIdx[i]);
    }
}
