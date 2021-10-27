package baekjoonAlgorithm;
import java.util.*;

class Player implements Comparable<Player>{
    private int money;
    private String name;
    public Player(int money, String name){
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
    public int compareTo(Player p){
        return Integer.compare(p.money, this.money);
    }
}
public class baekjoon_11098 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int t = 0; t < testCase; t++){
            ArrayList<Player> list = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                int money = sc.nextInt();
                String name = sc.next();

                list.add(new Player(money, name));
            }
            Collections.sort(list);
            System.out.println(list.get(0).getName());
        }
    }
}
