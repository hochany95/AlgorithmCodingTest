package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_18310 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> antenna = new ArrayList<>();
        for (int i=0; i<n; i++){
            antenna.add(sc.nextInt());
        }

        Collections.sort(antenna);
        int half = (n%2 == 1)? n/2 : n/2 - 1;

//        int min = (int)1e9;
//        int ans = -1;
//

        System.out.println(antenna.get(half));
    }
}
