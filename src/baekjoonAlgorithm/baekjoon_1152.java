package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] line = input.split(" ");
        System.out.println((input.length() < 1)? 0:line.length);
    }
}
