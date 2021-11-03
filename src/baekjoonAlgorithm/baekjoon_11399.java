package baekjoonAlgorithm;

import java.util.*;
//class BankPerson implements Comparable<BankPerson>{
//    private int num, time;
//
//    public BankPerson(int num, int time) {
//        this.num = num;
//        this.time = time;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    @Override
//    public int compareTo(BankPerson o) {
//        return Integer.compare(this.time, o.time);
//    }
//}
public class baekjoon_11399 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> users = new ArrayList<>();
        for(int i=0; i<n; i++)
            users.add(sc.nextInt());
        Collections.sort(users);

        int total = 0, sum = 0;
        for(int i=0; i<users.size(); i++)
        {
            sum += users.get(i);
            total += sum;
        }
        System.out.println(total);
    }
}
