package datastructure.hash_functions;

public class BadHashFunction {

	/*
	 * Generally, any hash algorithm that relies primarily on a commutative
	 * operation will have an exceptionally bad distribution. This hash
	 * fails to treat permutations differently, so “abc”, “cba”, and “cab”
	 * will all result in the same hash value.
	 */	
	static int additiveHash(String s){
		int hash=0;
		for(int i=0;i<s.length();i++){
			hash += s.charAt(i);
		}
		return hash;
	}
	
	static int xorHash(String s){
		int hash=0;
		for(int i=0;i<s.length();i++){
			hash ^= s.charAt(i);
		}
		return hash;
	}
	
	public static void main(String[] args) {
		System.out.println("additive hash");
		System.out.println(BadHashFunction.additiveHash("abc"));
		System.out.println(BadHashFunction.additiveHash("bac"));
		System.out.println(BadHashFunction.additiveHash("cab"));
		
		System.out.println("xor hash");
		System.out.println(BadHashFunction.xorHash("abc"));
		System.out.println(BadHashFunction.xorHash("bac"));
		System.out.println(BadHashFunction.xorHash("cab"));
	}
}
