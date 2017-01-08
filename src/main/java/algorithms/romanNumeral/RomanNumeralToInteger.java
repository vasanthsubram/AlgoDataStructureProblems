package algorithms.romanNumeral;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasanth on 12/1/16.
 */
public class RomanNumeralToInteger {

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
        System.out.println("LLCCCDXL = " + convert("LLCCCDXL")); //140
        System.out.println("XCL = " + convert("XCL")); //140
        System.out.println("XLLL = " +convert("XLLL")); //140
        System.out.println("LLL = " + convert("LLL"));   //150
        System.out.println("XLI = " +convert("XLI"));   //41
        System.out.println("MDCCC = " + convert("MDCCC"));   //1800

        System.out.println("IX = " + convert("IX"));      //9

        System.out.println("XIV = "  + convert("XIV"));      //14

        System.out.println(convert("XLIX"));      //49

        System.out.println(convert("LIX"));         //59
        System.out.println(convert("XCIX"));        //99
        System.out.println(convert("MCMXC"));   //1990
        System.out.println("MCMXCIX = " + convert("MCMXCIX"));     //1999
        System.out.println("IMM = " + convert("IMM"));     //1999
        System.out.println(convert("MMCCCXLIII"));   //2343
    }

    /*
    start from the end of the given string and go backwards
    keep track of the highest numeral
        if the current numeral is greater than the highest numeral, add it to sum; otherwise substract
     */
    private static int convert(String roman){
        int sum=0;
        char maxChar=roman.charAt(roman.length()-1);

        for(int i=roman.length()-1;i>=0;i--){
            char currChar=roman.charAt(i);
            int currVal = valueMap.get(currChar);
            int maxVal = valueMap.get(maxChar);

            if(currVal>=maxVal){
                sum=sum+currVal;
                maxChar=currChar;
            } else {
                sum=sum-currVal;
            }
//            System.out.print(sum + "\t");
        }
        System.out.println();
        return sum;
    }
}
