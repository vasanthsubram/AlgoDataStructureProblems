package algorithms.arrays;

/*
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

public class StringCompression {
    public static void main(String args[]){
        System.out.println(compress("aabcccccaaa"));  //a2b1c5a3
        System.out.println(compress("abcd"));  //abcd
        System.out.println(compress("aabbccdd"));   //aabbccdd

    }

    static String compress(String input){
        StringBuffer stringBuffer=new StringBuffer(input.length());
        char curr=input.charAt(0);
        int count=0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==curr){
                count++;
            } else{
                stringBuffer.append(curr);
                stringBuffer.append(count);
                count=1;
                curr=input.charAt(i);
            }
        }
        stringBuffer.append(curr);
        stringBuffer.append(count);
        if(input.length()<=stringBuffer.toString().length()){
            return input;
        }
        return stringBuffer.toString();
    }
}
