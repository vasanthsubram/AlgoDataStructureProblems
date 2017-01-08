package algorithms.romanNumeral;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vasanth on 12/1/16.
 */
public class IntegerToRomanNumeral {
    static LinkedHashMap<Integer,String> valueMap;

    static {
        valueMap=new LinkedHashMap<>();

        valueMap.put(1,"I");
        valueMap.put(2,"II");
        valueMap.put(3,"III");

        valueMap.put(4,"IV");

        valueMap.put(5,"V");
        valueMap.put(10,"X");
        valueMap.put(50,"L");
        valueMap.put(100,"C");
        valueMap.put(500,"D");
        valueMap.put(1000,"M");
    }

    public static void main(String[] args){

        System.out.println(convert(10));
        System.out.println(convert(100));
        System.out.println(convert(143));
//        System.out.println(convert(1999));
    }

    /*
        cannot use the same numeral more than 3 times at a time

     */
    private static String convert(int input){
        if(valueMap.get(input)!=null){
            return "" + valueMap.get(input);
        }


        StringBuffer numeral=new StringBuffer();

        int [] descValueList = {1000,500,100,50,10,5,1};

        for(int val: descValueList){
            int quotient=input/val;
            if(quotient>0){
                for(int i=0;i<quotient;i++){
                    numeral.append(valueMap.get(val));
                }
                input=input-(quotient*val);
                if(input==0) return numeral.toString();
            }
        }
        return numeral.toString();
    }
}
