package algorithms.duplicateInString;

import java.util.BitSet;

public class DuplicateCharacterInStringUsingBitVector {
    public static void main(String args[]){

        run("hel8o");
        run("hel8o8");
        run("HelLo");


    }

    static void run(String input){
        BitSet bitSet=new BitSet();

        for(char c: input.toUpperCase().toCharArray()){
            if(bitSet.get(c)){
                System.out.println(input + " has duplicate of " + c);
                return;
            } else{
                bitSet.set(c);
            }
        }
        System.out.println(input + " has no duplicate character");
    }
}
