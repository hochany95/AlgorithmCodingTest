package baekjoonAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1759 {
    public static void dfs(ArrayList<ArrayList<Character>> result, char[] arr, char [] box, boolean[] visited, int start, int n, int depth) {
        if (depth == n) {
            ArrayList<Character> temp = new ArrayList<>();
            for (int i = 0; i < box.length; i++) {
                temp.add(box[i]);
            }
            result.add(temp);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                box[depth] = arr[i];
                dfs(result, arr, box, visited, i, n, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean possible(ArrayList<Character> arr) {
        int vow = 0;//모음
        int con = 0;//자음
        for (int i = 0; i < arr.size(); i++) {
            int c = (int)arr.get(i);
            if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
                vow++;
            }else{
                con++;
            }
        }
        if(vow>=1 && con>=2) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[] arr = new char[c];
        //a, e, i, o, u
        //97, 101, 105, 111, 117
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        char[] box = new char[l];
        boolean[] visited = new boolean[c];

        dfs(result, arr, box, visited, 0, l, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if(possible(result.get(i))){
                for (int j = 0; j < result.get(i).size(); j++) {
                    sb.append(result.get(i).get(j));
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
