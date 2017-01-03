package algorithms.bitmanipulation;

public class BitOperations {

		public static void main(String args[]){
			for (int i = 0; i < 8; i++) {
				byte b = 1;
				byte template = 1;
				b = (byte) (b | (template << (byte) i));
				System.out.println(b);
			}
		}
}
