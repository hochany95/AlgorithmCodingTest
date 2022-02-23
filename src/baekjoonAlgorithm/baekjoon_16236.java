package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_16236 {
    public static class User {
        private int r, c, size, feed;


        public User(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.feed = 0;
        }

        public void set(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void takeFeed() {
            this.feed += 1;
            if (size <= feed) {
                this.size += 1;
                this.feed = 0;
            }
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getSize() {
            return size;
        }
    }

    public static class Position implements Comparable<Position> {
        private int r, c, dist;

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getDist() {
            return dist;
        }

        @Override
        public int compareTo(Position o) {
            if (this.getDist() != o.getDist()) {
                return Integer.compare(this.dist, o.dist);
            } else if (this.getR() != o.getR()) {
                return Integer.compare(this.r, o.r);
            } else {
                return Integer.compare(this.c, o.c);
            }
        }
    }

    public static int[][] map;
    public static User user = null;

    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    user = new User(i, j, 2);//초기 사이즈 2
                    map[i][j] = 0;
                }
            }
        }
        int result = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            Queue<Position> q = new LinkedList<>();
            ArrayList<Position> feeds = new ArrayList<>();
            boolean isFind = false;

            q.offer(new Position(user.getR(), user.getC(), 0));
            visited[user.getR()][user.getC()] = true;
            while (!q.isEmpty()) {
                Position now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now.getR() + dr[i];
                    int nc = now.getC() + dc[i];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                    if (!visited[nr][nc] && map[nr][nc] <= user.getSize()) {//가능한길 혹은 먹을 수 잇음
                        visited[nr][nc] = true;
                        if(map[nr][nc] > 0 && map[nr][nc]<user.getSize()){
                            feeds.add(new Position(nr, nc, now.getDist() + 1));
                            isFind = true;
                        }else{
                            q.offer(new Position(nr, nc, now.getDist() + 1));
                        }
                    }
                }
            }

            if(isFind){
                Collections.sort(feeds);
                Position feed = feeds.get(0);
                user.set(feed.getR(), feed.getC());
                user.takeFeed();
                result += feed.getDist();
                map[feed.getR()][feed.getC()] = 0;

            }else{//먹을 수 있는 것이 없음
                break;
            }
        }
        System.out.println(result);
    }
}
