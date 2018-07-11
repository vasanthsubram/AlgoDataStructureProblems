package algorithms.duplicateInString;

import java.util.HashSet;

public class DuplicateCharacterInString {
    public static void main(String args[]){
        run("hel8o");
        run("hel8o8");
        run("HelLo");
    }

    static void run(String input){
        HashSet<Character> hashSet=new HashSet<>();
        for(char c: input.toUpperCase().toCharArray()){
            if(hashSet.contains(c)){
                System.out.println(input + "  has duplicate of " + c);
                return;
            } else{
                hashSet.add(c);
            }
        }
        System.out.println(input + "  has no duplicate character");
    }
}
