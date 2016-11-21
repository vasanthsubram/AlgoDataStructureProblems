package datastructure.hash_functions;

public class BetterHashFunctions {
	
	/*
	 * The rotating hash is identical to the XOR hash except instead of simply
	 * folding each byte of the input into the internal state, it also performs
	 * a fold of the internal state before combining it with the each byte of
	 * the input. This extra mixing step is enough to give the rotating hash a
	 * much better distribution. Much of the time, the rotating hash is
	 * sufficient, and can be considered the minimal acceptable algorithm.
	 * Notice that with each improvement, the internal state is being mixed up
	 * more and more. This is a key element in a good hash function.
	 */
	static int xorRotateHash(String s){
		int hash=0;
		for(int i=0;i<s.length();i++){
			hash = (hash << 4) ^ (hash >> 28) ^ s.charAt(i);
		}
		return hash;
	}
	
	public static void main(String[] args) {
		System.out.println("xor rotate hash");
		System.out.println(BetterHashFunctions.xorRotateHash("abc"));
		System.out.println(BetterHashFunctions.xorRotateHash("bac"));
		System.out.println(BetterHashFunctions.xorRotateHash("cab"));
	}

}
