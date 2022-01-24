package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2343 {

    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cd = new int[n];
        int[] box = new int[m];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cd[i] = Integer.parseInt(st.nextToken());
            sum += cd[i];
        }

        int start = 1;
        int end = sum;
        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int bIdx = 0;
            int cIdx = 0;
            while (bIdx < m && cIdx < n) {
                box[bIdx] += cd[cIdx];
                if (box[bIdx] > mid) {
                    bIdx++;
                    continue;
                }
                cIdx++;
            }
            if (bIdx == m) {//크기가 작아서 초과
                start = mid + 1;
            }
            else if(cIdx == n){//크기가 넉넉해서 다 들어감
                ans = mid;
                end = mid-1;
            }

            Arrays.fill(box, 0);

        }
        System.out.println(ans);
    }
}
