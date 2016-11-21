package algorithms.general;

import java.lang.reflect.Field;

public class SizeCalculator {

	public static void main(String args[]) {
		TempObject o = new TempObject();
		System.out.println(new SizeCalculator().getSize(o));
	}

	public int getSize(Object o){
		Field[] fields = o.getClass().getDeclaredFields();
		int size=0;
		for(Field f: fields){
			if(f.getType().isPrimitive()){
				size = size + this.primitiveSize(f.getType().getName());
			}
			if(f.getType().isInstance(new Object())){
				//size=size+this.getSize(o)
				
			}
			if(f.getType().isArray()){
				if(f.getType().getComponentType().isPrimitive()){
					int aSize= this.primitiveSize(f.getType().getComponentType().getName());
					
				}
			}
		}
		return size;
	}

	private int primitiveSize(String typeName) {

		if (typeName.equals("int")) {
			return 32;
		}
		if (typeName.equals("long")) {
			return 64;
		}
		if (typeName.equals("short")) {
			return 16;
		}
		if (typeName.equals("byte")) {
			return 8;
		}
		if (typeName.equals("char")) {
			return 16;
		}
		if (typeName.equals("float")) {
			return 32;
		}
		if (typeName.equals("double")) {
			return 64;
		}
		return 0;
	}
}


class TempObject{
	int x;
	int y;
	long[] longArray;
}