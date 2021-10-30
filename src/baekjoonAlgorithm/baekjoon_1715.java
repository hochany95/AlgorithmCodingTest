package baekjoonAlgorithm;


import java.util.*;

public class baekjoon_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> card = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            card.offer(sc.nextInt());

        if (card.size() < 2) {//카드뭉치가 1개일 경우 0번
            System.out.print(0);
            return;
        }

        int total = 0;
        while(card.size() > 1){
            int n1 = card.poll();
            int n2 = card.poll();
            total += n1+n2;
            card.offer(n1+n2);
        }
        System.out.print(total);
    }
}
