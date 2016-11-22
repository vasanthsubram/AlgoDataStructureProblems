package utils;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableEntity implements Externalizable{
	int x;
	int y;
	int dontPersist;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDontPersist() {
		return dontPersist;
	}
	public void setDontPersist(int dontPersist) {
		this.dontPersist = dontPersist;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		x=in.readInt();
		y=in.readInt();
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
	}
	
}
