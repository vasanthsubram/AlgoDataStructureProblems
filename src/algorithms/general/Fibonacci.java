package algorithms.general;

public class Fibonacci {

	public static void main(String[] args) {
		int x1 = 1;
		int x2 = 1;

		System.out.println(x1);
		System.out.println(x2);

		for (int i = 0; i < 20; i++) {
			x2 = x1 + x2;
			x1 = x2 - x1;
			System.out.println(x2);
		}
	}
}
