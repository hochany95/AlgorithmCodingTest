package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1316 {
    public static boolean solution(String s) {
        if (s.length() < 2) {
            return true;
        }
        int[] alpha = new int[26];
        char w = s.charAt(0);
        alpha[w - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            if (w != now) {
                if (alpha[now - 'a'] > 0) {
                    return false;
                }else{
                    w = now;
                    alpha[now - 'a']++;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++){
            if(solution(br.readLine()))
                count++;
        }
        System.out.println(count);
    }
}
