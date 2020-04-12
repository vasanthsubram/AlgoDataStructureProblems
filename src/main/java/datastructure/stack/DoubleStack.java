package datastructure.stack;

import java.util.Arrays;

/*
 * Implement 2 stacks in a single array
 */
public class DoubleStack {
	
	private Integer[] array ;
	private Integer leftTop;
	private Integer rightTop;
	private Integer size ;

	public DoubleStack ( Integer size ) {
		this.array = new Integer[size] ;
		this.leftTop = -1 ;
		this.rightTop = size ;
		this.size = size ;
	}

	public void leftPush(Integer item ) {
		if ( leftTop < (rightTop - 1) ) {
			array[++leftTop] = item ;
		}
		else {
			System.out.println( "Stack OverFlow. Unable to Push " + item );
		}
	}
	
	public void rightPush ( Integer item ) {
		if ( leftTop < (rightTop - 1) ) {
			array[--rightTop] = item ;
		}
		else {
			System.out.println( "Stack OverFlow. Unable to Push " + item );
		}
	}
	
	public Integer leftPop( ) {
		if ( leftTop > -1 ) {
			Integer item = array[leftTop--] ;
			return item ;
		}
		else {
			System.out.println( "Stack UnderFlow" );
			return Integer.MIN_VALUE ;
		}
	}
	
	public Integer rightPop( ) {
		if ( rightTop < size ) {
			Integer item = array[rightTop++] ;
			return item ;
		}
		else {
			System.out.println( "Stack UnderFlow" );
			return Integer.MIN_VALUE ;
		}
	}
	
	public String toString() {
		return Arrays.toString(array);
	}
	
	public static void main(String[] args) {
		DoubleStack stack = new DoubleStack(10) ;
		stack.leftPush(1);
		stack.rightPush(100);
		stack.leftPush(2);
		stack.leftPush(3);
		stack.leftPush(4);
		stack.rightPush(101);
		System.out.println( "Stack = " + stack.toString() );

		
		System.out.println( "Pop1 = " + stack.leftPop() );
		System.out.println( "Pop1 = " + stack.leftPop() );
		System.out.println( "Pop1 = " + stack.leftPop() );
		System.out.println( "Pop1 = " + stack.leftPop() );
//		System.out.println( "Pop1 = " + stack.leftPop() );
		System.out.println( "Pop2 = " + stack.rightPop() );
		System.out.println( "Pop2 = " + stack.rightPop() );
	}
}