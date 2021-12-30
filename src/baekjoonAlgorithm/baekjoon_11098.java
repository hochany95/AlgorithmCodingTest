package baekjoonAlgorithm;
import java.util.*;

class Player_11098 implements Comparable<Player_11098>{
    private int money;
    private String name;
    public Player_11098(int money, String name){
        this.money = money;
        this.name = name;
    }
    public int getMoney(){
        return this.money;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Player_11098 p){
        return Integer.compare(p.money, this.money);
    }
}
public class baekjoon_11098 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int t = 0; t < testCase; t++){
            ArrayList<Player_11098> list = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                int money = sc.nextInt();
                String name = sc.next();

                list.add(new Player_11098(money, name));
            }
            Collections.sort(list);
            System.out.println(list.get(0).getName());
        }
    }
}
