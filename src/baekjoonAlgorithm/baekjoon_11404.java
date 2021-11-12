package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_11404 {

    /*
    * 플로이드 와셜 알고리즘*/
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final int INF = (int)1e9;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(map[a][b] == INF || map[a][b] > c){
                map[a][b] = c;
            }

        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print((map[i][j] != INF)? map[i][j]+" " : 0+" ");
            }
            System.out.println();
        }
    }
}
