package algorithms.bitmanipulation;

/*
 * There are N integers in an array A. 
 * All but one integer occurs in pairs. 
 * Your task is to find out the number that occurs only once.
 * N is odd number
 */
public class LonelyInteger_XOR {

	// a XOR a = 0
	//xor each element with its neighbor
	static int lonelyInteger2(int[] a){
		int j=0;
		for(int i=0;i <= a.length-1;i++) {
			j=j^a[i];
		}
		return j;
	}

	public static void main(String[] args) {
		int[] a2 = new int[] { 5, 5, 6, 6, 7, 7, 20 };
		int[] a3 = new int[] { 5, 5, 6, 7, 7 };

		System.out.println(lonelyInteger2(a2));
		System.out.println(lonelyInteger2(a3));
	}
}
