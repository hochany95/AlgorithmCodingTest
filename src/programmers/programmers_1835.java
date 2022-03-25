package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class programmers_1835 {
    public static ArrayList<ArrayList<Integer>> comb;
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(Solution(n, data));
    }

    private static int Solution(int n, String[] data) {
        comb = new ArrayList<>();
        Map<Character, Integer> nameTable = new HashMap<>();
        Character[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        for (int i = 1; i < 9; i++) {
            nameTable.put(name[i-1], i);
        }

        //전체 경우의 수 찾기
        boolean[] visited = new boolean[9];
        int[] arr = new int[8];
        findComb(arr, visited, 0);


        //찾은 경우의 수로 조건에 맞은 경우 탐색
        int count = 0;

        for (int i = 0; i < comb.size(); i++) {
            ArrayList<Integer> now = comb.get(i);
            //모든 조건이 맞아야 트루
            boolean isPossible = true;
            //조건 탐색
            ask:
            for (int j = 0; j < data.length; j++) {
                int from = nameTable.get(data[j].charAt(0));
                int fIdx = -1;

                int to = nameTable.get(data[j].charAt(2));
                int tIdx = -1;
                for (int k = 0; k < now.size(); k++) {
                    if(now.get(k) == from)
                        fIdx = k;
                    if(now.get(k) == to)
                        tIdx = k;
                }

                char comp = data[j].charAt(3);
                int value = data[j].charAt(4) - '0';
                int diff = Math.abs(fIdx - tIdx) - 1;

                if(comp == '=' && diff != value) {
                    isPossible = false;
                    break ask;
                }
                else if(comp == '<' && !(diff < value))
                {
                    isPossible = false;
                    break ask;
                }
                else if(comp == '>' && !(diff>value))
                {
                    isPossible = false;
                    break ask;
                }

            }
            if(isPossible) count++;
        }
        return count;
    }

    private static void findComb(int[] arr, boolean[] visited, int depth) {
        if (depth == 8) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                temp.add(arr[i]);
            }
            comb.add(temp);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                findComb(arr, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
