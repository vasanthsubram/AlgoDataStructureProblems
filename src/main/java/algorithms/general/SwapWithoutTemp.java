package algorithms.general;

public class SwapWithoutTemp {

	public static void main(String args[]){
		SwapWithoutTemp instance = new SwapWithoutTemp();
		instance.swapWithOutTemp();
		instance.swapWithOutTemp2();
		instance.swapWithOutTemp3();
		
		System.out.println(1 <2);
		
		
		short s1 = 1;
		short s2 = 1;
		
		System.out.println(s1^s2);
		
		char c1 = 'a';
		char c2 = 'b';
		System.out.println(c1^c2);
	}
	
	public void swapWithOutTemp(){
		int x = 100;  
        int y = 200;  
        
        System.out.println("x = " + x + "  y = " + y);
        
        x=x+y;
        y=x-y;
        x=x-y;
        
        System.out.println("x = " + x + "  y = " + y);
        System.out.println();
	}
	
	public void swapWithOutTemp2(){
		int x = -1;  
        int y = 3;  
        
        System.out.println("x = " + x + "  y = " + y);
        
        x=x^y;
        y=x^y;
        x=x^y;
        
        System.out.println("x = " + x + "  y = " + y);
        System.out.println();
	}
	
	public void swapWithOutTemp3(){
		int x = 3;  
        int y = 17;  
        
        System.out.println("x = " + x + "  y = " + y);
        
        x=x*y;
        y=x/y;
        x=x/y;
        
        System.out.println("x = " + x + "  y = " + y);
        System.out.println();
	}
}


