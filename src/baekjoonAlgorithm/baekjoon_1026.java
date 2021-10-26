package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++)
            arrA.add(sc.nextInt());
        for(int i=0; i<n; i++)
            arrB.add(sc.nextInt());

        Collections.sort(arrA);
        Collections.sort(arrB, Collections.reverseOrder());

        int total = 0;
        for(int i=0; i<n; i++){
            total += arrA.get(i) * arrB.get(i);
        }
        System.out.println(total);
    }
}
