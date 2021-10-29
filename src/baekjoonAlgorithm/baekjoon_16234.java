package baekjoonAlgorithm;

import java.util.*;
class Position_16234 {
    private int x, y;

    public Position_16234(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class baekjoon_16234 {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean isUnited = false;

    public static int findUnited(int[][] map, int[][] united, Position_16234 p, int l, int r, int idx) {
        Queue<Position_16234> q = new LinkedList<>();
        int len = map.length;
        int nx, ny, diff;
        int total = map[p.getX()][p.getY()], count = 1;
        q.offer(p);
        while (!q.isEmpty()) {
            Position_16234 now = q.poll();
            for (int i = 0; i < 4; i++) {
                nx = now.getX() + dx[i];
                ny = now.getY() + dy[i];
                if (nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
                diff = Math.abs(map[now.getX()][now.getY()] - map[nx][ny]);
                if (united[nx][ny] == 0 && diff >= l && diff <= r) {
                    isUnited = true;
                    united[nx][ny] = idx;
                    q.offer(new Position_16234(nx, ny));
                    total += map[nx][ny];
                    count++;
                }
            }
        }
        return total / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, l, r;
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][] united = new int[n][n];//연합 정도 저장
        int[] moved = new int[n * n + 1];// 연합 이후 idx 에 따른 인구 변화 정보 저장
        int idx;
        int answer = 0;//출력 정답
        while (true) {
            idx = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (united[i][j] == 0) {//연합 확인 못한 나라
                        united[i][j] = idx;//현재 idx 로 지정
                        Position_16234 p = new Position_16234(i, j); // 현재 위치
                        int population = findUnited(map, united, p, l, r, idx);// 현재 위치와 연합되는 나라 확인 및 최종 인구 계산
                        moved[idx] = population;// 연합 번호별 인구 변화 정보
                        idx++;// 다음 연합 번호 지정, 반복 수행으로 모든 나라 연합 수행
                    }
                }
            }
            if (!isUnited) break;//연합된 나라가 없으면 끝
            isUnited = false;//있으면 다시 초기화
            answer++;//몇번 이동했는가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = moved[united[i][j]];
                }//연합 정보 확인 후 각 나라 인구 변화 적용
            }
            for (int i = 0; i < n; i++) Arrays.fill(united[i], 0);
        }
        System.out.println(answer);
    }
}
