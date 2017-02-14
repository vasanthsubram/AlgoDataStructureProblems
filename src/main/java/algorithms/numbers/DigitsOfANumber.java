package algorithms.numbers;

import java.util.LinkedList;

public class DigitsOfANumber {

	public static void main(String[] args) {
		int x = 123456;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		while(x>0){
			stack.push( x % 10 );
		    x = x / 10;
		}
		
		while (!stack.isEmpty()) {
		    System.out.println(stack.pop());
		}
	}
}
