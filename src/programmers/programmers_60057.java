package programmers;

import java.io.IOException;

public class programmers_60057 {
    public static void main(String[] args) throws IOException {

        String s = "aa";
        int ans = Solution(s);
        System.out.println(ans);
    }

    private static int Solution(String s) {
        //aabbacc
        //최단 길이를 출력
        int min = (int)1e9;
        // 길이 절반까지 탐색 - 탐색 단위
        if (s.length() == 1) {
            min = 1;
            return min;
        }
        for (int subSize = 1; subSize <= s.length() / 2; subSize++) {
            // 지금 단위에 대한 결과물 이후 길이 계산
            StringBuilder sb = new StringBuilder();
            // 구간 추출을 위한 인덱스
            int startIdx = 0;
            int endIdx = startIdx + subSize;

            String prev = "";//이전값과 비교를 위한 변수
            int count = 1;//같은단어 변수

            //마지막값 변화에 따라 가능한 범위까지 탐색
            while (true) {
                // 종료 조건
                // 구간이 딱 맞는 경우
                // 조금 부족한 경우


                String now = s.substring(startIdx, endIdx);
                // 이전과 같은 경우
                // 카운트 증가, 정답에 추가하지는 않는다.
                if (now.equals(prev)) {//
                    count++;
                }
                // 같지 않은 경우, 이전까지 결과 입력 prev 변경, 카운트 초기화
                else{
                    if (count > 1) {
                        sb.append(String.valueOf(count));
                        sb.append(prev);
                    }else{
                        sb.append(prev);
                    }
                    prev = now;
                    count = 1;
                }
                // 구간 범위 변경
                // 0, 2 /
                //[0][1][2][3][4][5][6][7][8]
                startIdx = endIdx;
                endIdx = endIdx + subSize;

                if (endIdx > s.length()) {
                    if (startIdx == s.length()) {
                        if(count > 1){
                            sb.append(count);
                        }
                        sb.append(now);
                        break;
                    }
                    // 조금 부족
                    else {
                        if (count > 1) {
                            sb.append(count);
                        }
                        sb.append(now);
                        sb.append(s.substring(startIdx, s.length()));
                        break;

                    }
                }

            }

            min = Math.min(min, sb.length());
        }
        return min;
    }
}
