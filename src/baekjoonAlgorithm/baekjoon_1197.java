package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_1197 {

    public static class Node implements Comparable<Node>{
        private int x,y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDist() {
            return dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static int[] parent = new int[10001];

    public static int findParent(int x) {
        if(parent[x] == x) return parent[x];
        else return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v; i++) {
            parent[i+1] = i+1;
        }

        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.add(new Node(x, y, d));
        }

        Collections.sort(arr);

        int sum = 0;
        for (Node node : arr) {
            int x = node.getX();
            int y = node.getY();

            if (findParent(x) != findParent(y)) {
                union(x, y);
                sum += node.getDist();
            }
        }
        System.out.println(sum);
    }
}
