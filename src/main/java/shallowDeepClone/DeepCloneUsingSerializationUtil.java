package shallowDeepClone;

import java.io.Serializable;
import org.apache.commons.lang3.SerializationUtils;

class Test1 implements Serializable
{
	int x, y;

	public Test1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class DeepCloneUsingSerializationUtil implements Serializable {

	String name;
	int id;
	Test1 t;

	DeepCloneUsingSerializationUtil(String name, int id, Test1 t) {
		this.name = name;
		this.id = id;
		this.t= t;
	}

	public DeepCloneUsingSerializationUtil getClone() {
		return SerializationUtils.clone(this);
	}

	public static void main(String args[]) throws CloneNotSupportedException {
		DeepCloneUsingSerializationUtil c1 = new DeepCloneUsingSerializationUtil("a", 1, new Test1(11,12));
		System.out.println("c1 "+ c1.name + " " + c1.id+ " " + c1.t.x + " " + c1.t.y);

		DeepCloneUsingSerializationUtil c2 = (DeepCloneUsingSerializationUtil) c1.getClone();
		c2.name = "b";
		c2.id = 2;
		c2.t.x=21;
		c2.t.y=22;
		System.out.println("c1 "+ c1.name + " " + c1.id+ " " + c1.t.x + " " + c1.t.y);
		System.out.println("c2 "+ c2.name + " " + c2.id+ " " + c2.t.x + " " + c2.t.y);
	}

}
