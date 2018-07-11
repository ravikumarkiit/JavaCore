

public class SingletonExample {
	
	private volatile static SingletonExample instance = null;
	
	private SingletonExample () {
		
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public static SingletonExample getInstance() {
		if(instance == null) {
			synchronized(SingletonExample.class) {
				if(instance == null) {
					System.out.println("getting instance");
					instance = new SingletonExample();
				}
			}
		}
		return instance;
	}
	
}
