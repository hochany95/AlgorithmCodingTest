package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_9251 {
    /*
    * 가장 긴 공통 부분수열 찾기*/
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        String line1 = sc.next();
        String line2 = sc.next();
        int[][] map = new int[line1.length()+1][line2.length()+1];
        int max = 0;
        for(int i=1; i<=line1.length(); i++){
            for(int j=1; j<=line2.length(); j++){
                if(line1.charAt(i-1) == line2.charAt(j-1))
                    map[i][j] = map[i-1][j-1] + 1;
                else
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                if(map[i][j] > max)
                    max = map[i][j];
            }
        }
        System.out.println(max);

    }
}
