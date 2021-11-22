package baekjoonAlgorithm;

import java.util.*;
public class baekjoon_10610 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nStr = sc.next();

        if(!nStr.contains("0")){
            System.out.println(-1);
        }else{
            int sum = 0;
            for(int i=0; i<nStr.length(); i++){
                sum += nStr.charAt(i) - '0';
            }
            if(sum % 3 != 0 || sum <= 0){
                System.out.println(-1);
            }else{
                Character[] cArr = new Character[nStr.length()];
                for(int i=0; i<nStr.length(); i++)
                    cArr[i] = Character.valueOf(nStr.charAt(i));

                Arrays.sort(cArr, Collections.reverseOrder());
                StringBuilder ans = new StringBuilder();
                for(int i=0; i<cArr.length; i++)
                    ans.append(cArr[i]);

                System.out.println(ans);
            }
        }
    }
}
