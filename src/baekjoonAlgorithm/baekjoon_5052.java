package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();

            }
            Arrays.sort(arr, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    int len = Math.min(o1.length(), o2.length());
                    for (int i = 0; i < len; i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return Character.compare(o1.charAt(i), o2.charAt(i));
                        }
                    }
                    return Integer.compare(o1.length(), o2.length());

                }
            });
            boolean ans = true;

            for (int i = 0; i < n-1; i++) {
                if (arr[i].length() <= arr[i + 1].length()) {
                    if (arr[i].equals(arr[i + 1].substring(0, arr[i].length()))) {
                        ans = false;
                        break;
                    }
                }
                else{
                    if (arr[i + 1].equals(arr[i].substring(0, arr[i + 1].length()))) {
                        ans = false;
                        break;
                    }
                }
            }
            System.out.println(ans ? "YES" : "NO");
        }
    }
}
