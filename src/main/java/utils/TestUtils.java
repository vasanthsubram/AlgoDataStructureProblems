package utils;

public class TestUtils {

	public static String getRandomString(int n) {
		char[] random = new char[n];
		int c = 'A';
		int r1 = 0;
		for (int i = 0; i < n; i++) {
			r1 = (int) (Math.random() * 3);
			switch (r1) {
			case 0:
				c = '0' + (int) (Math.random() * 10);
				break;
			case 1:
				c = 'a' + (int) (Math.random() * 26);
				break;
			case 2:
				c = 'A' + (int) (Math.random() * 26);
				break;
			}
			random[i] = (char) c;
		}
		return new String(random);
	}
	
	public static String getRandomString() {
		
		int x = (int)(Math.random()*47);
		return getRandomString(x+7);
	}
}
