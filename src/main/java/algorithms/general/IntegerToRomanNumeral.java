package algorithms.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasanth on 12/1/16.
 */
public class IntegerToRomanNumeral {
    static Map<Character,Integer> valueMap;

    static {
        valueMap=new HashMap<>();

        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
    }

    public static void main(String[] args){

        System.out.println(convert(9));
    }

    private static String convert(int value){
        String numeral="";


        return numeral;
    }
}
