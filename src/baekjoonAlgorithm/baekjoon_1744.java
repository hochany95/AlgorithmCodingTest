package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class baekjoon_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0)
                pos.offer(input);
            else
                neg.offer(input);
        }

        int ans = 0;
        while (pos.size() > 1) {
            int a = pos.poll();
            int b = pos.poll();
            ans += Math.max(a*b, a+b);

        }
        while (neg.size() > 1) {
            int a = neg.poll();
            int b = neg.poll();
            ans += Math.max(a*b, a+b);

        }
        if (!pos.isEmpty())
            ans += pos.poll();

        if (!neg.isEmpty())
            ans += neg.poll();

        System.out.println(ans);
    }
}
