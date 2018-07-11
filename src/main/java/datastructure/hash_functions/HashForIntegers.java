package datastructure.hash_functions;

public class HashForIntegers {

    public static void main(String[] args){
        System.out.println(hash(123));
        System.out.println(hash(12));
        System.out.println(hash(112));
        System.out.println(hash(124));
        System.out.println(hash(142));
    }

    public static int hash(int x){
        return x%97; //divisor is a prime
    }
}
