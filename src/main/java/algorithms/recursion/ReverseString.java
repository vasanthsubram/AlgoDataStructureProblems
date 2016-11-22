package algorithms.recursion;

public class ReverseString {


	public static void main(String[] args) {
		String s = "why did the chicken cross the road ?";
			
		System.out.println(reverseMe_recursive(s));
	}
	
	static String reverseMe_recursive(String s) {
		   if(s.length() == 0)
		     return "";
		   return s.charAt(s.length() - 1) + reverseMe_recursive(s.substring(0,s.length()-1));
		 }

}
