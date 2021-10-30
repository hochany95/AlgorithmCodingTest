package programmers;
import java.util.*;
class Game implements Comparable<Game>{
    private int Num;
    private float failP;

    public Game(int num, float failP) {
        Num = num;
        this.failP = failP;
    }

    public int getNum() {
        return Num;
    }

    @Override
    public int compareTo(Game o) {
        if(this.failP != o.failP) return Float.compare(o.failP, this.failP);
        else return Integer.compare(this.Num, o.Num);
    }
}
public class programmers_42889 {

    public static int[] solution(int N, int[] stages){
        int[] failCount = new int[N+2];
        int len = stages.length;
        for(int i=0; i<len; i++)
            failCount[stages[i]]++;

        ArrayList<Game> result = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(len!=0){
                float percent = failCount[i] / (float)len;
                result.add(new Game(i, percent));
            }else{
                result.add(new Game(i, 0));
            }
            len -= failCount[i];
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).getNum();
        }
        return answer;

    }
    public static void main(String[] args){

        int n = 5;
        int[] stage = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result = solution(n, stage);
        System.out.println("example1\n 출력값: ");
        for(int i=0; i<result.length; i++)
            System.out.print(result[i]+" ");
        System.out.println("\n기대값: 3 4 2 1 5");

        n = 4;
        int[] stage2 = {4, 4, 4, 4, 4};
        int[] result2 = solution(n, stage2);
        System.out.println("\nexample2\n 출력값: ");
        for(int i=0; i<result2.length; i++)
            System.out.print(result2[i]+" ");
        System.out.println("\n기대값: 4 1 2 3");
    }
}
