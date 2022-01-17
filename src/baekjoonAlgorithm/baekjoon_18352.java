package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_18352 {

    public static final int INF = (int)1e9;
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static int[] d = new int[300001];
    static class Node {
        private int index, distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }
    }
    public static void dijkstra(int start) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        d[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int idx = node.getIndex();
            for (int i = 0; i < list.get(idx).size(); i++) {
                if(d[list.get(idx).get(i).getIndex()] > d[idx]+1){
                    d[list.get(idx).get(i).getIndex()] = d[idx]+1;
                    q.offer(new Node(list.get(idx).get(i).getIndex(), 1));
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, 1));
        }

        Arrays.fill(d, INF);
        dijkstra(x);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb.length()>1? sb.toString():-1);
    }
}
