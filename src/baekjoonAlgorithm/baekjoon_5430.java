package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TEST_CASE = Integer.parseInt(br.readLine());
        loop:
        for (int T = 0; T < TEST_CASE; T++) {
            String ins = br.readLine();

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            String input = br.readLine();
            String[] values = input.substring(1, input.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }

            int start = 0;
            int end = n - 1;

            boolean reverse = false;

            for (int i = 0; i < ins.length(); i++) {
                char c = ins.charAt(i);
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (start > end) {
                        System.out.println("error");
                        continue loop;
                    }
                    if (!reverse) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (start == end) {
                sb.append(arr[start]);
            }else if(start < end){
                if (!reverse) {
                    while (start < end) {
                        sb.append(arr[start]+",");
                        start++;
                    }
                    sb.append(arr[start]);
                }else{
                    while (start < end) {
                        sb.append(arr[end] + ",");
                        end--;
                    }
                    sb.append(arr[end]);
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}
