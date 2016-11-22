package algorithms.strings;

public class ReverseString_InPlace {


	public static void main(String[] args) {
		String s = "why did the chicken cross the road ?";
			
	    char [] str_ch = s.toCharArray();
	    char temp;
	    int len = str_ch.length;
	    int left = len-1;

	    for(int right =0; right<len/2 ;right++,left--){
	        temp = str_ch[left];
	        str_ch[left] = str_ch[right];
	        str_ch[right] = temp;
	    }
	    System.out.println(new String(str_ch));
	}
}
