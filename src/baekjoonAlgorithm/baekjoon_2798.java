package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_2798 {
    public static int min, answer;
    public static void findCard(int[] arr, int[] output, boolean[] visited, int start, int depth, int m){
        if(depth == 3){
            int total = 0;
            for(int i=0; i<3; i++){
                total += output[i];
            }
            if(total<=m && Math.abs(total-m) < min){
                min = Math.abs(total - m);
                answer = total;
            }
            return;
        }

        int n = arr.length;
        for(int i=start; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                findCard(arr, output, visited, i+1, depth+1, m);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        min = m;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] output = new int[3];
        boolean[] visited = new boolean[n];
        findCard(arr, output, visited, 0, 0, m);
        System.out.println(answer);
    }
}
