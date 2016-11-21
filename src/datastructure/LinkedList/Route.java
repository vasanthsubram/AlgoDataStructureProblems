package datastructure.LinkedList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Route {
	String name;
	int number;
	String[] stops;
	
	public static Route readFrom(DataInputStream stream) throws IOException{
		Route instance;
		Object obj;
		instance = new Route();
		obj = stream.readUTF();
		instance.setName(stream.readUTF());
		instance.setRouteNumber(stream.readInt());
		return instance;
	}
	
	public Route(){}
	
	public Route(String aName, int routeNumber){
		name = aName;
		number = routeNumber;
	}
	
	public String toString(){
		return (name + "  " + number);
	}
	
	public void saveInto(DataOutputStream stream) throws IOException{
		stream.writeUTF(name);
		stream.writeInt(number);
	//	if(stops != null){
	//		for(int i=0;i<stops.length; i++){
	//			stream.writeChars(stops[i]);
	//		}
	//	}
		
	}
	
	public void setName(String aName){
		name = aName;
	}
	public void setRouteNumber(int routeNumber){
		number = routeNumber;
	}
}
