package thread;

public class StaticSynchronizedEx extends Thread{

	public void run() {
		method1();
	}

	synchronized static void method1() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
