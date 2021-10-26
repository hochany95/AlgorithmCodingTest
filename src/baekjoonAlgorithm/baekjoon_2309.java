package baekjoonAlgorithm;
import java.util.*;
public class baekjoon_2309 {
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public static void find(int[] h, boolean[] visited, int[]out, int count, int total){
        if(count >= 7){
            if(total == 100){
                ArrayList<Integer> ans = new ArrayList<>();
                for(int i=0; i<out.length; i++){
                    ans.add(out[i]);
                }
                result.add(ans);
                return;
            }else{
                return;
            }
        }

        for(int i=count; i<h.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[count] = h[i];
                int weight = total + h[i];
                find(h, visited, out, count+1, weight);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] height = new int[9];
        for(int i=0; i<9; i++){
            height[i] = sc.nextInt();
        }

        int[] temp = new int[7];
        boolean[] visited = new boolean[9];

        find(height, visited, temp, 0, 0);
        ArrayList<Integer> print = result.get(0);
        Collections.sort(print);
        for(int i=0; i<print.size(); i++){
            System.out.println(print.get(i));
        }

    }
}
