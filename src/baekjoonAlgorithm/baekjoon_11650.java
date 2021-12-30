package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Position_11650 implements Comparable<Position_11650>{
    private int x;
    private int y;

    public Position_11650(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Position_11650 o) {
        if(this.x != o.x){
            return Integer.compare(this.x, o.x);
        }else{
            return Integer.compare(this.y, o.y);
        }
    }
}
public class baekjoon_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Position_11650> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Position_11650(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Position_11650 p : list) {
            sb.append(p.getX() + " " + p.getY()+"\n");
        }
        System.out.println(sb);
    }
}
