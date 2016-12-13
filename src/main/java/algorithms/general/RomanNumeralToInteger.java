package algorithms.general;

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
        System.out.println(convert("XLLL")); //140
        System.out.println(convert("LLL"));   //150
        System.out.println(convert("XLI"));   //41
        System.out.println(convert("MDCCC"));   //1800

        System.out.println(convert("IX"));      //9

        System.out.println(convert("XIV"));      //14

        System.out.println(convert("XLIX"));      //49

        System.out.println(convert("LIX"));         //59
        System.out.println(convert("XCIX"));        //99
        System.out.println(convert("MCMXC"));   //1990
        System.out.println(convert("MCMXCIX"));     //1999
        System.out.println(convert("MMCCCXLIII"));   //2343
    }

    private static int convert(String roman){
        int sum=0;
        char max=roman.charAt(roman.length()-1);
        for(int i=roman.length()-1;i>=0;i--){
            char curr=roman.charAt(i);
            int currVal = valueMap.get(curr);
            int maxVal = valueMap.get(max);

            if(currVal>=maxVal){
                sum=sum+currVal;
                max=curr;
            } else {
                sum=sum-currVal;
            }
        }
        return sum;
    }
}
