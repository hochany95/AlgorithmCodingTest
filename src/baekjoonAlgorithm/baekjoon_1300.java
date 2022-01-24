package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;

        while (start < end) {
            long mid = start + (end - start) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {//mid보다 작은 값이 k개 보다 작다 > mid 를 키워야 b[k]를 찾을 수 있다.
                start = mid + 1;
            } else {// mid 보다 작은 값이 k를 넘는다.
                end = mid;
            }
        }
        System.out.println(end);
    }
}
