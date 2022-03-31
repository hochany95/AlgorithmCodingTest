package programmers;
import java.io.IOException;
import java.util.*;
public class programmers_60063 {
    public static void main(String[] args) throws IOException {


        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));


    }

    private static class Robot{
        int r1, c1, r2, c2;
        int count;

        public Robot(int r1, int c1, int r2, int c2, int count) {

            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            Robot nObj = (Robot) obj;
            if(this.r1 == nObj.r1 && this.r2 == nObj.r2 && this.c1 == nObj.c1 && this.c2 == nObj.c2){
                return true;
            }else
                return false;
        }
    }
    private static int solution(int[][] board) {
        Queue<Robot> q = new LinkedList<>();
        ArrayList<Robot> visited = new ArrayList<>();
        int n = board.length;
        q.offer(new Robot(0, 0, 0, 1, 0));
        final int[] dr = {-1, 0, 1, 0};
        final int[] dc = {0, 1, 0, -1};
        int ans = 0;

        loop:
        while (true) {
            Robot robot = q.poll();
            for (int i = 0; i < visited.size(); i++) {
                if(visited.get(i).equals(robot))
                    continue loop;
            }
            visited.add(robot);
            if((robot.r1 == n-1 && robot.c1 == n-1) || (robot.r2 == n-1 && robot.c2 == n-1)){
                ans = robot.count;
                break;
            }

            //단순 이동
            // 위, 오, 아래, 왼
            for (int i = 0; i < 4; i++) {
                int nr1 = robot.r1 + dr[i];
                int nc1 = robot.c1 + dc[i];
                int nr2 = robot.r2 + dr[i];
                int nc2 = robot.c2 + dc[i];

                if(nr1 < 0 || nr2 < 0 || nc1 < 0 || nc2 < 0)
                    continue;
                if(nr1 >= n || nr2 >= n || nc1 >= n || nc2 >= n)
                    continue;
                if(board[nr1][nc1] == 1 || board[nr2][nc2] == 1)
                    continue;

                q.offer(new Robot(nr1, nc1, nr2, nc2, robot.count+1));
            }
            // 회전


            if(robot.r1 == robot.r2){//가로로 놓여 있을 경우
                if (robot.r1 - 1 >= 0  && robot.r2 - 1 >= 0) {
                    if(board[robot.r1 - 1][robot.c1] == 0 && board[robot.r2 - 1][robot.c2] == 0){
                        q.offer(new Robot(robot.r1, robot.c1, robot.r1 - 1, robot.c1, robot.count+1));
                        q.offer(new Robot(robot.r2, robot.c2, robot.r2 - 1, robot.c2, robot.count+1));
                    }
                }

                if (robot.r1 + 1 < n && robot.r2 + 1 < n) {
                    if(board[robot.r1 + 1][robot.c1] == 0 && board[robot.r2 + 1][robot.c2] == 0){
                        q.offer(new Robot(robot.r1, robot.c1, robot.r1 + 1, robot.c1, robot.count+1));
                        q.offer(new Robot(robot.r2, robot.c2, robot.r2 + 1, robot.c2, robot.count+1));
                    }
                }

            }else{//세로로 놓여있는 경우
                if (robot.c1 - 1 >= 0 && robot.c2 - 1 >= 0) {
                    if(board[robot.r1][robot.c1 - 1] == 0 && board[robot.r2][robot.c2 - 1] == 0){
                        q.offer(new Robot(robot.r1, robot.c1, robot.r1, robot.c1-1, robot.count+1));
                        q.offer(new Robot(robot.r2, robot.c2, robot.r2, robot.c2-1, robot.count+1));
                    }
                }

                if (robot.c1 + 1 < n && robot.c2 + 1 < n) {
                    if(board[robot.r1][robot.c1 + 1] == 0 && board[robot.r2][robot.c2 + 1] == 0){

                        q.offer(new Robot(robot.r1, robot.c1, robot.r1, robot.c1+1, robot.count+1));
                        q.offer(new Robot(robot.r2, robot.c2, robot.r2, robot.c2+1, robot.count+1));
                    }
                }
            }

        }

        return ans;
    }

}
