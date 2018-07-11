package algorithms.duplicateInString;

import java.util.Arrays;

public class DuplicateCharacterInStringWithoutDataStructure {

    public static void main(String args[]){
        run("hel8o");
        run("hel8o8");
        run("HelLo");
    }

    static void run(String in){
        char[] temp = in.toUpperCase().toCharArray();
        Arrays.sort(temp);
        String input = new String(temp);

        char c=input.charAt(0);
        for(int i=1;i<input.length();i++){
            if(c==input.charAt(i)){
                System.out.println(in + " has duplicate of " + c);
                return;
            } else{
                c=input.charAt(i);
            }
        }
        System.out.println(in + " has no duplicate character");
    }
}
