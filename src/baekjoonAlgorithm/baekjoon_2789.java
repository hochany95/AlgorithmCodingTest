package baekjoonAlgorithm;
import java.util.*;
public class baekjoon_2789 {

    public static void main(String[] args) {
        String delString = "CAMBRIDGE";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder answer = new StringBuilder();
        boolean appended;
        for(int i=0; i<input.length(); i++){
            appended = true;
            for(int j=0; j<delString.length(); j++){
                if(input.charAt(i) == delString.charAt(j)){
                    appended = false;
                    break;
                }
            }
            if(appended) answer.append(input.charAt(i));
        }
        System.out.println(answer.toString());

    }
}
