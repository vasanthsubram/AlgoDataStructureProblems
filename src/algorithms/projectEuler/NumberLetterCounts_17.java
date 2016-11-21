package algorithms.projectEuler;

import java.util.HashMap;
import java.util.Map;

public class NumberLetterCounts_17 {

	/*
	 	one 		3
	 	two			3
	 	three		5
	 	four		4
	 	five		4
	 	six			3
	 	seven		5
	 	eight		5
	 	nine		4
	 	ten			3
	 	eleven		6
	 	twelve		6
	 	thirteen	8
	 	fourteen	8
	 	fifteen		7
	 	sixteen		7
	 	seventeen	9
	 	eighteen	8
	 	nineteen	8
	 	twenty		6
	 	thirty		6
	 	forty		5
	 	fifty		5
	 	sixty		5
	 	seventy		7
	 	eighty		6
	 	ninety		6
	 	hundred		7
	 	thousand	8
	 	and			3
	 	
	 	1 - 20
	 	21 -99
	 	100s
	 	101-999 (excluding hundreds)
	 	1000
	 */
	
	static Map<Integer, Integer> numberCount= new HashMap<Integer,Integer>();
	static{
		numberCount.put(0,0);
		numberCount.put(1,3);
		numberCount.put(2,3);
		numberCount.put(3,5);
		numberCount.put(4,4);
		numberCount.put(5,4);
		numberCount.put(6,3);
		numberCount.put(7,5);
		numberCount.put(8,5);
		numberCount.put(9,4);
		numberCount.put(10,3);
		numberCount.put(11,6);
		numberCount.put(12,6);
		numberCount.put(13,8);
		numberCount.put(14,8);
		numberCount.put(15,7);
		numberCount.put(16,7);
		numberCount.put(17,9);
		numberCount.put(18,8);
		numberCount.put(19,8);
		numberCount.put(20,6);
		numberCount.put(30,6);
		numberCount.put(40,5);
		numberCount.put(50,5);
		numberCount.put(60,5);
		numberCount.put(70,7);
		numberCount.put(80,6);
		numberCount.put(90,6);
		numberCount.put(1000,8);
	}
	
	public static void main(String[] args) {
	
		long start = System.nanoTime();
		int count =0;
		int AND=3;
		int HUNDRED=7;
		
		for(int i=1;i<=20;i++){
			count = count+numberCount.get(i);
		}
		
		for(int i=21;i<=99;i++){
			int d2 = i%10;
			int d1 = i-d2;
			count=count+numberCount.get(d1)+numberCount.get(d2);
		}
		
		for(int i=100;i<=999;i++){
			int d1 = i/100;
			//100,200...900
			count=count+numberCount.get(d1)+HUNDRED;
			
			//101-120, 201-220,... 901-920
			if(i%100<=20){
				if(i%100>0){ //ignore 100,200...
					count=count+AND+numberCount.get(i%100);
					//System.out.println(((i/100)*100)+(i%100));
				}
			} else{
				//121-199, 221-299, ...>921-999
				int d3 = i%10;
				int d2 = (i-(d1*100))-d3;
				count=count+AND+numberCount.get(d2)+numberCount.get(d3);
				//System.out.println(d1*100+d2+d3);
			}
		}
		
		//1000
		count=count+numberCount.get(1)+numberCount.get(1000);
		
		System.out.println("Total time ns= " + (System.nanoTime() - start));
		System.out.println("Total characters used = " + count);
	}

}
