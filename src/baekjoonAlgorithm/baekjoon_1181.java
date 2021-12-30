package baekjoonAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(br.readLine());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length())
                    return o1.length() - o2.length();
                else{
                    return o1.compareTo(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        String prev = "";
        for (String s : list) {
            if(!s.equals(prev)){
                prev = s;
                sb.append(s + "\n");
            }
        }
        System.out.println(sb);
    }
}
