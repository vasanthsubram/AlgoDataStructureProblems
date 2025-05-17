package algorithms.dynamic.factorial;

public class Fibonacci {

	public static void main(String[] args) {
		int x1 = 1, x2 = 1;

		System.out.println(x1);
		System.out.println(x2);

		for (int i = 0; i < 29; i++) {
			int sum = x1 +x2;
			System.out.print(sum);
			System.out.print("\t");
			x1=x2;
			x2=sum;
		}
	}
}
