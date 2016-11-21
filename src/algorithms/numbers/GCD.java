package algorithms.numbers;

import static org.junit.Assert.assertTrue;

/**
 * Greatest common divisor
 * 
 * @author subramav
 *
 */
public class GCD {

	 // return gcd(|m|, |n|)
    public static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
        //if m==n, then m % n = 0 and in the next iteration, return m
        //if m % n = 0 , it means m is evenly divided by n and in the next iteration, return the m 
        //if m % n = 1, it means
    }
    public static long gcd_iteration(long m, long n){
    	while(m>0 && n>0){
    		if(m>n){
    			m=m%n;
    		} else{
    			n=n%m;
    		}
    	}
    	return (m==0)?n:m;
    }
    
   
    
    public static void main(String[] args) {
    	System.out.println(gcd_iteration(4,4));
    	assertTrue(gcd_iteration(4,4)==gcd(4,4));
    		
    	System.out.println(gcd_iteration(4,2));
    	assertTrue(gcd_iteration(4,2)==gcd(4,2));
    	
    	System.out.println(gcd_iteration(12,13));
    	assertTrue(gcd_iteration(12,13)==gcd(12,13));
    	
    	System.out.println(gcd_iteration(1989,867));
    	assertTrue(gcd_iteration(1989,867)==gcd(1989,867));
    	
    	System.out.println(gcd_iteration(1071,462));
    	assertTrue(gcd_iteration(1071,462)==gcd(1071,462));
	}
}
