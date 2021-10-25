package programmers;
import java.util.*;
public class programmers_72410 {
    //신규 아이디 추천
    public static String solution(String new_id){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length(); i++){
            int iChar = (int)new_id.charAt(i);
            if(iChar>=(int)'a' && iChar<=(int)'z'){//통과
                sb.append(new_id.charAt(i));
            }else if(iChar>=(int)'A' && iChar<=(int)'Z'){//소문자로 변환 후 저장
                sb.append(String.valueOf(new_id.charAt(i)).toLowerCase());
            }else if(iChar>=(int)'0' && iChar<=(int)'9'){//숫자 통과
                sb.append(new_id.charAt(i));
            }else if(iChar == (int)'-' || iChar == (int)'_' || iChar == (int)'.'){
                sb.append(new_id.charAt(i));
            }
        }//2단계까지 완료

        String temp = sb.toString();
        StringBuilder ans = new StringBuilder();
        boolean predot = false;//"." 중복 체크
        for(int i=0; i<temp.length(); i++){
            if(temp.charAt(i) != '.'){
                ans.append(temp.charAt(i));
                predot = false;
            }else{
                if(!predot){
                    predot = true;
                    ans.append(temp.charAt(i));
                }
            }
        }//3단계 완료

        if(ans.length()<1)
            ans.append("a");

        if(ans.substring(0, 1).equals("."))
            ans.delete(0, 1);

        if(ans.length()<1)
            ans.append("a");

        if(ans.substring(ans.length()-1, ans.length()).equals("."))
            ans.delete(ans.length()-1, ans.length());
        //4단계 완료

        if(ans.length()<1)
            ans.append("a");
        //5단계 완료

        if(ans.length()>=16){
            String answer = ans.substring(0, 15);
            if(answer.charAt(14) == '.')
                return answer.substring(0, 14);
            else
                return answer;
        }
        while(ans.length()<=2){
            ans.append(ans.substring(ans.length()-1, ans.length()));
        }
        return ans.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String new_id = sc.next();
        System.out.println(solution(new_id));
    }
}
