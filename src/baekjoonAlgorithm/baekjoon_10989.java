package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] sortArr = new int[10001];
        for (int i = 0; i < n; i++) {
            sortArr[Integer.parseInt(br.readLine())]++;
        }

        int idx = 0;
        while(n>0){
            while(sortArr[idx]==0) idx++;
            sb.append(idx+"\n");
            sortArr[idx]--;
            n--;
        }
        System.out.println(sb.toString());
    }
}
