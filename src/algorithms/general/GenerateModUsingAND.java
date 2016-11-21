package algorithms.general;

public class GenerateModUsingAND {

		public static void main(String args[]){
			System.out.println("Mod 1  of any number= " + 121%1);
			
			for(int i=0;i<17;i++){
				System.out.print(i%8 + "\t");
			}
			System.out.println("\n");
			//Mod can be generated using AND 
			//but ONLY for (2^n)-1 numbers (3,7,15,31,63,etc.,)
			int modFactor=5;
			
			for(int i=0;i<12;i++){
				System.out.println(i & modFactor);
			}
		}
}
