package baekjoonAlgorithm;

import java.util.*;

public class baekjoon_10026 {

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void checkColor(char[][] map, boolean[][] visited, char c, int n, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || map[i][j] != c) {
            return;
        }
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            checkColor(map, visited, c, n, nx, ny);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }


        boolean[][] visitedNorm = new boolean[n][n];
        int rCnt = 0, gCnt = 0, bCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedNorm[i][j]) {
                    if (map[i][j] == 'R') {
                        rCnt++;
                        checkColor(map, visitedNorm, 'R', n, i, j);
                    }
                    else if (map[i][j] == 'G') {
                        gCnt++;
                        checkColor(map, visitedNorm, 'G', n, i, j);
                    }
                    else if (map[i][j] == 'B') {
                        bCnt++;
                        checkColor(map, visitedNorm, 'B', n, i, j);
                    }

                }
            }
        }
        boolean[][] visitedB = new boolean[n][n];
        int rNGCnt = 0;
        int nBCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='G')
                    map[i][j] = 'R';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedB[i][j]) {
                    if (map[i][j] == 'R') {
                        rNGCnt++;
                        checkColor(map, visitedB, 'R', n, i, j);
                    }
                    else if (map[i][j] == 'B') {
                        nBCnt++;
                        checkColor(map, visitedB, 'B', n, i, j);
                    }

                }
            }
        }
        System.out.println((rCnt+gCnt+bCnt)+" "+(rNGCnt+nBCnt));
    }
}
