package algorithms.numbers;

public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return 0;
        }
        String s = Integer.toString(Math.abs(x));
        StringBuffer buf = new StringBuffer();

        int len=s.length();
        for(int i=0;i<len;i++){
            buf.append(s.charAt(len-i-1));
        }
        long result = Long.parseLong(buf.toString());
        if(result>Integer.MAX_VALUE){
            return 0;
        }
        if(x<0) {
            return Math.negateExact((int)result);
        } else{
            return (int)result;
        }

    }
}
