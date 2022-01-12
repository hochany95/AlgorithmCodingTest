package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_1931 {

    static class Meet implements Comparable<Meet>{
        private int startTIme, endTime;

        public int getStartTIme() {
            return startTIme;
        }

        public int getEndTime() {
            return endTime;
        }

        public Meet(int startTIme, int endTime) {
            this.startTIme = startTIme;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meet o) {
            if(this.endTime != o.endTime){
                return Integer.compare(this.endTime, o.endTime);
            }else{
                return Integer.compare(this.startTIme, o.startTIme);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meet> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int ans = 1;
        int end = list.get(0).getEndTime();
        for (int i = 1; i < n; i++) {
            if(list.get(i).getStartTIme() >= end){
                ans++;
                end = list.get(i).getEndTime();
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}
