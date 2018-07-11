
public class Sample {
	

	public static void main(String[] args) {
		SingletonExample se = SingletonExample.getInstance();
		se = null;
		se = SingletonExample.getInstance();
		System.out.println(se);
	}
	
}
