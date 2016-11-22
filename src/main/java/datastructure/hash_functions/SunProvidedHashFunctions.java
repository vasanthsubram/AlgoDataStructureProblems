package datastructure.hash_functions;

import java.util.Arrays;

public class SunProvidedHashFunctions {

	public static void main(String[] args) {
	
		Object[] arr = {new Object()};
		System.out.println(Arrays.hashCode(arr));
		
		Object[] arr2 = {new Object()};
		System.out.println(Arrays.hashCode(arr2));

		System.out.println(Arrays.equals(arr, arr2));
	}

}
