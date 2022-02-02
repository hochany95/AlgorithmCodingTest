package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2178 {
    public static int dr[] = {1, 0, -1, 0};
    public static int dc[] = {0, 1, 0, -1};
    public static int min = (int) 1e9;

    static class Node {
        private int row;
        private int col;
        private int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getCount() {
            return count;
        }
    }

    public static int bfs(int[][] map, boolean[][] visited) {
        int n = map.length;
        int m = map[0].length;
        int[][] countMap = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.getRow();
            int col = node.getCol();
            int c = node.getCount();

            if (!visited[row][col]) {
                visited[row][col] = true;
                countMap[row][col] = c;

                if (row == n - 1 && col == m - 1) break;

                for (int i = 0; i < 4; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (map[nr][nc] == 1 && !visited[nr][nc]) {
                            q.offer(new Node(nr, nc, c + 1));
                        }
                    }
                }
            }
        }

        return countMap[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(bfs(map, visited));
    }
}
