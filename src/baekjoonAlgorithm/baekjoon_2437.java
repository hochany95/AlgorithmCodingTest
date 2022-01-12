package baekjoonAlgorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2437 {

    /*이코테 만들수 없는 금액과 같은 유형
    target 을 증가시키며 가능여부를 확인
    다음 coin 이 작거나 같으면 target 을 만들 수 있다
    coin 과 target 이 같으면 coin 으로 만들 수 있다
    coin 이 target 보다 클 결우 target 을 만들 수 없다
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);

        int target = 1;
        for (int i = 0; i < n; i++) {
            if (target <= coin[i]) {
                break;
            }
            target += coin[i];
        }

        bw.write(Integer.toString(target));
        bw.flush();
        br.close();
        bw.close();
    }
}
