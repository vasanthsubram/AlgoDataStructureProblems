package algorithms.general;

class Fibonacci_Clever {
	public static void main(String[] a) {
		int prev = 0;
		int next = 1;
		while (prev < 1000) {
			next = prev + (prev = next);
			System.out.println(prev);
		}
	}
}