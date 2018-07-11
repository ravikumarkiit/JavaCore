package shallowDeepClone;

class Test
{
	int x, y;

	public Test(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ShallowDeepClone implements Cloneable {

	String name;
	int id;
	Test1 t;

	ShallowDeepClone(String name, int id, Test1 t) {
		this.name = name;
		this.id = id;
		this.t= t;
	}

	public Object clone() throws CloneNotSupportedException
	{
		/**For Shallow Clone*/
		/*return super.clone(); */		
		
		/**For deep Clone object Type need to be copied separately*/
		ShallowDeepClone c1 =  (ShallowDeepClone) super.clone(); 
		c1.t = new Test1(this.t.x, this.t.y);
		return c1;
	}

	public static void main(String args[]) throws CloneNotSupportedException {
		ShallowDeepClone c1 = new ShallowDeepClone("a", 1, new Test1(11,12));
		System.out.println("c1 "+ c1.name + " " + c1.id+ " " + c1.t.x + " " + c1.t.y);

		ShallowDeepClone c2 = (ShallowDeepClone) c1.clone();
		c2.name = "b";
		c2.id = 2;
		c2.t.x=21;
		c2.t.y=22;
		System.out.println("c1 "+ c1.name + " " + c1.id+ " " + c1.t.x + " " + c1.t.y);
		System.out.println("c2 "+ c2.name + " " + c2.id+ " " + c2.t.x + " " + c2.t.y);
	}

}
