package datastructure.stack;

/*
 * Implement 2 stacks in a single array
 */
public class DoubleStack {
	
	private Integer[] array ;
	private Integer top1 ;
	private Integer top2 ;
	private Integer size ;

	public DoubleStack ( Integer size ) {
		this.array = new Integer[size] ;
		this.top1 = -1 ;
		this.top2 = size ;
		this.size = size ;
	}

	public void push1 ( Integer item ) {
		if ( top1 < (top2 - 1) ) {
			array[++top1] = item ;
		}
		else {
			System.out.println( "Stack OverFlow. Unable to Push " + item );
		}
	}
	
	public void push2 ( Integer item ) {
		if ( top1 < (top2 - 1) ) {
			array[--top2] = item ;
		}
		else {
			System.out.println( "Stack OverFlow. Unable to Push " + item );
		}
	}
	
	public Integer pop1 ( ) {
		if ( top1 > -1 ) {
			Integer item = array[top1--] ;
			return item ;
		}
		else {
			System.out.println( "Stack UnderFlow" );
			return Integer.MIN_VALUE ;
		}
	}
	
	public Integer pop2 ( ) {
		if ( top2 < size ) {
			Integer item = array[top2++] ;
			return item ;
		}
		else {
			System.out.println( "Stack UnderFlow" );
			return Integer.MIN_VALUE ;
		}
	}
	
	public String toString() {
		String arr = new String() ;
		arr = "[ " ;
		for (int j = 0; j < array.length; j++) {
			arr = arr + this.array[j] + " " ;
		}
		return arr + " ]";
	}
	
	public static void main(String[] args) {
		DoubleStack stack = new DoubleStack(5) ;
		stack.push1(1);
		stack.push2(5);
		stack.push1(2);
		stack.push1(3);
		stack.push1(4);
		System.out.println( "Stack = " + stack.toString() );
		stack.push2(6);
		
		System.out.println( "Pop1 = " + stack.pop1() );
		System.out.println( "Pop1 = " + stack.pop1() );
		System.out.println( "Pop1 = " + stack.pop1() );
		System.out.println( "Pop1 = " + stack.pop1() );
		System.out.println( "Pop1 = " + stack.pop1() );
		System.out.println( "Pop2 = " + stack.pop2() );
		System.out.println( "Pop2 = " + stack.pop2() );
	}
}