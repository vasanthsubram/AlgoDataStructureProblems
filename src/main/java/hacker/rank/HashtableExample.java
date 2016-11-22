package hacker.rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        Map<String,Integer> magazine = new HashMap<String,Integer>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String input=in.next();
            Integer sCount=magazine.get(input);
            if(sCount!=null){
                magazine.put(input,(sCount+1));
            } else{
                magazine.put(input,1);
            }
        }

        Map<String,Integer> ransom = new HashMap<String,Integer>();
        for(int i=0; i < n; i++){
            String input=in.next();
            Integer sCount=ransom.get(input);
            if(sCount!=null){
                ransom.put(input,(sCount+1));
            } else{
                ransom.put(input,1);
            }
        }

        String result="Yes";

        if(ransom.size()>magazine.size()){
            System.out.println("No");
            return;
        }
        for(String s: ransom.keySet()){
            if(!(magazine.containsKey(s))){
                System.out.println("No");
                return;
            }
            if(ransom.get(s)>magazine.get(s)){
                System.out.println("No");
                return;
            }
        }
        System.out.println(result);
    }
}