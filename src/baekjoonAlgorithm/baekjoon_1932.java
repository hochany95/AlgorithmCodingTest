package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1932 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
            for(int j=0; j<i+1; j++){
                tree.get(i).add(sc.nextInt());
            }
        }
        ArrayList<ArrayList<Integer>> sumTree = new ArrayList<>();
        for(int i=0; i<n; i++)
            sumTree.add(new ArrayList<>());
        sumTree.get(0).add(tree.get(0).get(0));
        for(int i=1; i<n; i++){
            sumTree.get(i).add(sumTree.get(i-1).get(0) + tree.get(i).get(0));//가장 좌측
            for(int j=1; j<i; j++){
                sumTree.get(i).add(Math.max(sumTree.get(i-1).get(j-1)+tree.get(i).get(j), sumTree.get(i-1).get(j) + tree.get(i).get(j)));
            }
            sumTree.get(i).add(sumTree.get(i-1).get(i-1) + tree.get(i).get(i));//가장 우측
        }

        Collections.sort(sumTree.get(n-1), Collections.reverseOrder());
        System.out.println(sumTree.get(n-1).get(0));

    }
}
