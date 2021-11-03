package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_8958 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String line = sc.next();
            int total = 0;
            int score = 0;
            for(int j=0; j<line.length(); j++){
                score = (line.charAt(j) - 'O' == 0)? score + 1 : 0;
                total += score;
            }
            System.out.println(total);
        }
    }
}
