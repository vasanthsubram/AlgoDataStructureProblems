package algorithms.strings;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWords {

	public static void main(String[] args) {

		String s = "why did the chicken cross the road ?";
		System.out.println(reverseWords(s));
		System.out.println(reverseWords2(s));
	}

	public static String reverseWords(String s){
	    StringTokenizer strTok = new StringTokenizer(s, " ");
	    Stack<String> stack=new Stack<String>();
	    StringBuilder buff=new StringBuilder();
	    while(strTok.hasMoreElements()) {
	        String str = (String)strTok.nextToken();
	        if(!str.equals("")) stack.push(str);
	    }
	    while(!stack.isEmpty()){
	        buff.append(stack.pop()); 
	        if(!stack.isEmpty()) buff.append(" ");
	    }
	    return buff.toString();
	 }
	
	public static String reverseWords2(final String sentence) {
		  final StringBuilder result = new StringBuilder();
		  final String[] words = sentence.split("\\s+");      
		  for (int i = words.length - 1 ; 0 <= i; i--) {
		    result.append(words[i]).append(' ');
		  }
		  return result.toString().trim();
		}
	
	
}
