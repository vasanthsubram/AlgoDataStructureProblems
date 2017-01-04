package algorithms.bitmanipulation;

public class GenerateModUsingAND {

		public static void main(String args[]){

			//using %
			for(int i=0;i<20;i++){
				System.out.print(i%8 + "\t");
			}
			System.out.println("\n");


			//Mod can be generated using AND 
			//but ONLY for (2^n)-1 numbers (3,7,15,31,63,etc.,)
			int modFactor=7;
			
			for(int i=0;i<20;i++){
				System.out.print(i & modFactor);
				System.out.print("\t");
			}
		}
}
