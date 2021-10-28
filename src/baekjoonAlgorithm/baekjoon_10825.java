package baekjoonAlgorithm;

import java.util.*;
class Score implements Comparable<Score>{
    private String name;
    private int kor, eng, math;
    public Score(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Score s){
        if(this.kor != s.kor) return Integer.compare(s.kor, this.kor);
        else if(this.eng != s.eng) return Integer.compare(this.eng, s.eng);
        else if(this.math != s.math) return Integer.compare(s.math, this.math);
        else return this.name.compareTo(s.name);
    }
}
public class baekjoon_10825 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         sc.nextLine();
         ArrayList<Score> list = new ArrayList<>();
         for(int i=0; i<n; i++){
             String[] line = sc.nextLine().split(" ");
             String name = line[0];
             int kor = Integer.parseInt(line[1]);
             int eng = Integer.parseInt(line[2]);
             int math = Integer.parseInt(line[3]);
             list.add(new Score(name, kor, eng, math));
         }
         Collections.sort(list);
         for(int i=0; i<n; i++)
             System.out.println(list.get(i).getName());
    }
}
