package core.strings;

public class CommonSubstring {

	public static String SubstringFromStart(String template, String testString){
		int i=0;
		int max= Math.min(template.length(), testString.length());
		for(i=0;(i < max && ((template.charAt(i)==testString.charAt(i))));i++);
		return template.substring(0,i);
	}
	
	public static void main(String[] args) {
		String s1 = "HelloKWorld";
		String s2 = "HelloWorld";
		System.out.println(SubstringFromStart(s1, s2));
	}

}
