package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_3665 {

    public static int[] indegree = new int[501];
    public static boolean[][] graph = new boolean[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TEST_CASE = Integer.parseInt(br.readLine());
        for (int T = 0; T < TEST_CASE; T++) {
            int n = Integer.parseInt(br.readLine());

            boolean cycled = false;
            boolean impossible = false;

            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            Arrays.fill(indegree, 0);
            for (int i = 0; i <= 500; i++) {
                Arrays.fill(graph[i], false);
            }

            ArrayList<Integer> rank = new ArrayList<>();//이전 순위..
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                rank.add(Integer.parseInt(st.nextToken()));
            }

            // 순위에 따른 차수 정보 입력...
            for (int i = 0; i < n - 1; i++) {
                int a = rank.get(i);
                for (int j = i + 1; j < n; j++) {
                    int b = rank.get(j);
                    indegree[b] += 1;
                    graph[a][b] = true;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b] -= 1;
                    indegree[a] += 1;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            for (int i = 0; i < n; i++) {
                if (q.size() > 1) {
                    impossible = true;
                    break;

                } else if (q.size() == 0) {
                    cycled = true;
                    break;
                }
                int now = q.poll();
                result.add(now);

                for (int j = 1; j <= n; j++) {
                    if (graph[now][j]) {
                        graph[now][j] = false;
                        indegree[j]--;
                        if (indegree[j] == 0)
                            q.offer(j);
                    }
                }
            }

            while(!q.isEmpty())
                q.poll();

            if (cycled) {
                System.out.println("IMPOSSIBLE");
            } else if (impossible) {
                System.out.println("?");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(result.get(i) + " ");
                }
                System.out.println(sb);
            }

        }
    }
}
