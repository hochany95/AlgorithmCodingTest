package programmers;
import java.util.*;
public class programmers_77484 {
    public static int[] solution(int[] lottos, int[] win_nums){
        //로또의 최고 순위와 최저 순위
        boolean[] correct = new boolean[46];
        for(int i=0; i<win_nums.length; i++){
            correct[win_nums[i]] = true;
        }
        int delCount = 0;
        int matched = 0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0)
                delCount++;
            else{
                if(correct[lottos[i]])
                    matched++;
            }
        }
        int max = (delCount+matched<2)? 6 : 7 - (delCount+matched);
        int min = (matched < 2)? 6 : 7 - matched;
        int[] ans = {max, min};
        return ans;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] lottos = new int[6];
        int[] win_num = new int[6];

        for(int i=0; i<6; i++){
            lottos[i] = sc.nextInt();
        }
        for(int i=0; i<6; i++){
            win_num[i] = sc.nextInt();
        }

        int[] answer = solution(lottos, win_num);
        System.out.println(answer[0] +" " +answer[1]);
    }
}
