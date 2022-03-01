package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphaValue = new int[26];
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for (int j = 0; j < words[i].length(); j++) {
                alphaValue[words[i].charAt(j)-'A'] += Math.pow(10, words[i].length() - 1 - j);
            }
        }
        /*
        각 자리에 해당하는 크기로 그리드 적용
        ABCDE
        ABD
        A B (A+C) (B+D) (D+E) == A0A00 + B0B0 + C00 + DD + E
         */


        int ans = 0;
        int[] values = new int[26];
        for (int i = 9; i > 0; i--) {
            int max = 0;
            int idx = 0;
            for (int j = 0; j < 26; j++) {
                if (max < alphaValue[j]) {
                    max = alphaValue[j];
                    idx = j;
                }
            }
            if(max == 0) break;
            else{
                values[idx] = i;
                ans += values[idx] * alphaValue[idx];
                alphaValue[idx] = -1;
            }
        }

        System.out.println(ans);
    }
}
