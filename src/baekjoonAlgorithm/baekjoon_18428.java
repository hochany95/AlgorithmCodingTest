package baekjoonAlgorithm;

import java.util.*;

class Position {
    private int r, c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getC() {
        return this.c;
    }

    public int getR() {
        return this.r;
    }
}

public class baekjoon_18428 {

    public static ArrayList<Position> teacher = new ArrayList<>();
    public static ArrayList<ArrayList<Position>> possibleComb = new ArrayList<>();
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void getPossible(char[][] map, Position[] output, int start, int n, int depth) {
        if (depth == 3) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                temp.add(new Position(output[i].getR(), output[i].getC()));
            }
            possibleComb.add(temp);
            return;
        }

        for (int i = start; i < n * n; i++) {
            int nr = i / n;
            int nc = i % n;
            if (map[nr][nc] == 'X') {
                map[nr][nc] = 'O';
                output[depth] = new Position(nr, nc);
                getPossible(map, output, i + 1, n, depth + 1);
                map[nr][nc] = 'X';
            }
        }
    }

    public static boolean checkAnswer(char[][] map, ArrayList<Position> teacher) {
        for (int i = 0; i < teacher.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int nx = teacher.get(i).getR();
                int ny = teacher.get(i).getC();
                while (true) {
                    if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) {
                        break;
                    }
                    if (map[nx][ny] == 'D') break;
                    if (map[nx][ny] == 'S') {
                        return false;
                    }
                    nx = nx + dx[j];
                    ny = ny + dy[j];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.next().charAt(0);
                if(map[i][j] == 'T')
                    teacher.add(new Position(i, j));
            }
        }

//        System.out.println("======map========");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        Position[] output = new Position[3];
        getPossible(map, output, 0, n, 0);//벽 설치 가능 조합 생성
//        System.out.println("가능한 조합의 수 ; " + possibleComb.size());

        boolean answer = false;
        for (int i = 0; i < possibleComb.size(); i++) {
            for (int j = 0; j < 3; j++) {
                Position p = possibleComb.get(i).get(j);
                map[p.getR()][p.getC()] = 'D';//디펜서 설치
            }
            if (checkAnswer(map, teacher)) {//현재 조합으로 가능하면 yes반환 후 종료
                answer = true;

//                System.out.println("가눙 조합");
//                for(int a=0; a<n; a++){
//                    for(int b=0; b<n; b++){
//                        System.out.print(map[a][b]+" ");
//                    }
//                    System.out.println();
//                }
                break;
            } else {
                for (int j = 0; j < 3; j++) {
                    Position p = possibleComb.get(i).get(j);
                    map[p.getR()][p.getC()] = 'X';
                }

            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}
