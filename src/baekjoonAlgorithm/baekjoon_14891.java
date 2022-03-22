package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_14891 {

    public static int[][] wheel = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //톱니바퀴 4개 변수 배열 / 리스트
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = input.charAt(j)-'0';
            }
        }

        int n = Integer.parseInt(br.readLine());//회전 횟수
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //wn : [1-4]
            int wn = Integer.parseInt(st.nextToken())-1;
            int wd = Integer.parseInt(st.nextToken());

            //회전 하기 전에 미리 다른 톱니를 확인한다.
            //배열에 담아서 전달?
            int[] turnArr = setTurnArr(wn, wd);
            turnByArr(turnArr);

        }
        int ans = checkTop();
        System.out.println(ans);
    }

    private static int[] setTurnArr(int wn, int wd) {
        int[] status = new int[4];
        status[wn] = wd;
        for (int i = 1; i < 4; i++) {//우측방향 2 - 6
            int next = wn + i;
            if(next > 3) break;
            //서로 극이 다르면 회전
            if (wheel[next - 1][2] != wheel[next][6]) {
                if(status[next-1] == 1)
                    status[next] = -1;
                else if(status[next-1] == -1)
                    status[next] = 1;
            }
        }
        for (int i = 1; i < 4; i++) {
            int prev = wn - i;
            if(prev < 0) break;
            //서로 극이 다르면 회전
            if (wheel[prev + 1][6] != wheel[prev][2]) {
                if(status[prev + 1] == 1)
                    status[prev] = -1;
                else if(status[prev+1] == -1)
                    status[prev] = 1;
            }
        }
        return status;
    }

    private static void turnByArr(int[] turnArr) {
        for (int i = 0; i < turnArr.length; i++) {
            if(turnArr[i] == 0) continue;
            turn(i, turnArr[i]);
        }
    }

    private static void turn(int n, int d) {
        //n - wheel num , i = direction
        int[] temp = Arrays.copyOf(wheel[n], 8);
        if(d == 1){
            wheel[n][0] = temp[7];
            for (int i = 0; i < 7; i++) {
                wheel[n][i+1] = temp[i];
            }
        }else if(d == -1){
            wheel[n][7] = temp[0];
            for (int i = 0; i < 7; i++) {
                wheel[n][i] = temp[i+1];
            }
        }
    }

    private static int checkTop() {
        int sum = 0;
        int[] score = {1, 2, 4, 8};
        for (int i = 0; i < 4; i++) {
            if(wheel[i][0] == 1)
                sum += score[i];
        }
        return sum;
    }
}
