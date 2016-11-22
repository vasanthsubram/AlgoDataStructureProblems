package algorithms.strings;


public class ReverseWord_InPlace {

	public static void main(String[] args) {
		String s = "why did the chicken cross the road ?";
		System.out.println(reverseString(s));
	}
	
	private static String reverseString(String input){
		
		char[] arr = input.toCharArray();
		revCharArray(arr,0,arr.length-1);
		
		int prev_space=0;
		
		for(int i=1;i<arr.length;i++){
			if(arr[i]==' ' || i==arr.length-1){
				int end = (i==arr.length-1)?i:i-1;
				revCharArray(arr,prev_space+1,end);
				prev_space=i;
			}
		}
		return new String(arr);
	}

	public static void revCharArray(char[] str_ch, int start, int end) {
		char temp;
		int len = end-start+1;
		int left = end;

		for (int right = start; right < start + (len / 2); right++) {
			temp = str_ch[left];
			str_ch[left] = str_ch[right];
			str_ch[right] = temp;
			left--;
		}
	}
}
