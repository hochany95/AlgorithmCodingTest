package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_2887 {

    public static int[] parent;

    public static int findParent(int x) {
        if(parent[x] == x) return parent[x];
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }
    public static class Star {
        private int x, y, z, n;

        public Star(int x, int y, int z, int n) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.n = n;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public int getN() {
            return n;
        }
    }
    public static class Node implements Comparable<Node>{
        private int x, y, dist;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        ArrayList<Star> list = new ArrayList<>();
        ArrayList<Node> edge = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new Star(x, y, z, i));
        }

        Collections.sort(list, (o1, o2) -> Integer.compare(o1.x, o2.x));
        for (int i = 1; i < n; i++) {
            edge.add(new Node(list.get(i - 1).getN(), list.get(i).getN(), Math.abs(list.get(i - 1).getX() - list.get(i).getX())));
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.y, o2.y));
        for (int i = 1; i < n; i++) {
            edge.add(new Node(list.get(i - 1).getN(), list.get(i).getN(), Math.abs(list.get(i - 1).getY() - list.get(i).getY())));
        }
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.z, o2.z));
        for (int i = 1; i < n; i++) {
            edge.add(new Node(list.get(i - 1).getN(), list.get(i).getN(), Math.abs(list.get(i - 1).getZ() - list.get(i).getZ())));
        }

        Collections.sort(edge);

        int sum = 0;
        for (Node node : edge) {
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
