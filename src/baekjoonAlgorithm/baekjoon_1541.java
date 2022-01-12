package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;

public class baekjoon_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] operand = input.split("\\+|-");

        int c = 0;
        ArrayList<Character> operator = new ArrayList<>();
        while (c < input.length()) {
            if (input.charAt(c) == '+' || input.charAt(c) == '-') {
                operator.add(input.charAt(c));
            }
            c++;
        }

        int sum = Integer.parseInt(operand[0]);
        int idx = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while (idx < operator.size()) {
            if (operator.get(idx) == '+') {
                sum += Integer.parseInt(operand[idx + 1]);
            } else {
                nums.add(sum);
                sum = Integer.parseInt(operand[idx + 1]);
            }
            idx++;
        }
        if (sum > 0) {
            nums.add(sum);
        }
        int ans = nums.get(0);

        if (nums.size() > 1) {
            for (int i = 1; i < nums.size(); i++) {
                ans -= nums.get(i);
            }
        }

        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();


    }
}
