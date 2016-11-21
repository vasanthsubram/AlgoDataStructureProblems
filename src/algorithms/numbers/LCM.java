package algorithms.numbers;

/**
 * Least common multiple
 * 
 * @author subramav
 *
 */
public class LCM {

	 // return lcm(|m|, |n|)
    public static long lcm(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n / GCD.gcd(m, n));    // parentheses important to avoid overflow
    }
    
    public static void main(String[] args) {
    	System.out.println(lcm(12,54));
    	System.out.println(lcm(2,2));
    	System.out.println(lcm(2,4));
    	System.out.println(lcm(45,89));
	}
}
