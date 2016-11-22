package algorithms.general;

public class SizeOfObject {

	public static void main(String args[]) {
		Runtime rt = Runtime.getRuntime();
		long mem1 = rt.freeMemory();
		System.out.println("Free memory is: " + mem1);
		
		int N = 100000;
		double[] b = new double[N];
		for(int i=0;i<b.length; i++){
			b[i]=1;
		}
		long mem2 = rt.freeMemory();
		System.out.println("Free memory is now: " + mem2);
		System.out.println("Object size might be: " + (double)(mem1 - mem2)/(double) N);
	
	}
	
	
}

