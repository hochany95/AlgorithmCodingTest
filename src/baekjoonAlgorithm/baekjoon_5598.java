package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_5598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            int t = input.charAt(i) - 3;
            if (t < (int) 'A') t += 26;
            sb.append((char) t);
        }
        System.out.println(sb.toString());
    }
}
