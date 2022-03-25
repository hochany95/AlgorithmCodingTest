package programmers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class programmers_17676 {


    public static void main(String[] args) throws IOException {
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"};
        System.out.println(Solution(lines));

    }

    private static int Solution(String[] lines) {

        ArrayList<LocalDateTime> start = new ArrayList<>();
        ArrayList<LocalDateTime> end = new ArrayList<>();
        ArrayList<Integer> progress = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < lines.length; i++) {
            //입력받은 정보 정리
            // 프로세스 시작시간, 종료 시간 정리
            st = new StringTokenizer(lines[i]);
            LocalDateTime lt = LocalDateTime.parse(st.nextToken()+" "+st.nextToken(), DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss.SSS"));
            end.add(lt);

            String progressTime = st.nextToken();
            float ptf = Float.parseFloat(progressTime.substring(0, progressTime.length()-1));
            int pti = (int)(ptf*1000) -1;
            progress.add(pti);
            lt = lt.minus(pti, ChronoUnit.MILLIS);
            start.add(lt);
        }

        // 이미 종료시간 기준으로 정렬됨
        // 각 정료 시간 기준으로 1초 탐색
        // 종료 시간 기준 시작시간이 빠른 것 탐색 - > 종료되지 않았음
        // 1초 뒤 기준 시작시간이 빠른것?
        // 방문 배열 이용 카운트
        int max = -1;

        for (int i = 0; i < end.size(); i++) {

            //기본 자기 시간
            int count = 1;
            //지금 차례의 끝시간과 1초 뒤 시간 준비
            LocalDateTime now = end.get(i);
            LocalDateTime nextSec = now.plus(999, ChronoUnit.MILLIS);
            for (int j = i; j < end.size(); j++) {
                // 각각 시작시간 비교
                if(i==j) {
                    continue;
                }


                LocalDateTime sldt = start.get(j);
                if (sldt.isBefore(now) || sldt.isBefore(nextSec) || sldt.isEqual(now) || sldt.isEqual(nextSec)) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
