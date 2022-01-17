package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1260 {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static void dfs(int idx, boolean[] visited) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 0; i < graph.get(idx).size(); i++) {
            if(!visited[graph.get(idx).get(i)])
                dfs(graph.get(idx).get(i), visited);
        }
    }

    public static void bfs(int idx, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        while (!q.isEmpty()) {
            int now = q.poll();
            if(!visited[now]){
                visited[now] = true;
                System.out.print(now + " ");
                for (int i = 0; i < graph.get(now).size(); i++) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//정점 개수
        int m = Integer.parseInt(st.nextToken());//간선 개수
        int v = Integer.parseInt(st.nextToken());//시작점

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[1001];
        dfs(v, visited);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v, visited);
    }
}
