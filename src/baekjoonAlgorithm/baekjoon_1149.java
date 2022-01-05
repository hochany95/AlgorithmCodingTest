package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] value = new int[3][n];
        int[][] dValue = new int[3][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            value[0][i] = Integer.parseInt(st.nextToken());
            value[1][i] = Integer.parseInt(st.nextToken());
            value[2][i] = Integer.parseInt(st.nextToken());
        }
        dValue[0][0] = value[0][0];
        dValue[1][0] = value[1][0];
        dValue[2][0] = value[2][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0){
                    dValue[0][i] = Math.min(dValue[1][i-1], dValue[2][i-1])+value[0][i];
                }else if(j==1){
                    dValue[1][i] = Math.min(dValue[0][i-1], dValue[2][i-1])+value[1][i];
                }else{
                    dValue[2][i] = Math.min(dValue[0][i-1], dValue[1][i-1])+value[2][i];
                }
            }
        }
        System.out.println(Math.min(Math.min(dValue[0][n - 1], dValue[1][n - 1]), dValue[2][n - 1]));
    }
}
