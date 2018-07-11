package thread;

class MyRunnable1 implements Runnable {

	public void run() {
		if(Thread.currentThread().getName().equals("Thread-1")) {
			System.out.println("Method1 called");
			method1();
		}
		else {
			System.out.println("Method2 called");
			method2();
		}
			
	}
	
	synchronized void method1() {
		System.out.println(Thread.currentThread().getName() + " method1() Has Started**");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " method1() Has ended**");
	}
	
	synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " method2() Has Started**");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " method2() Has ended**");
	}

}

public class SynchronizationOutput {
	
	public static void main(String[] args) throws InterruptedException{
		MyRunnable1 myRunnable1 = new MyRunnable1();
		Thread t1 = new Thread(myRunnable1, "Thread-1");
		Thread t2 = new Thread(myRunnable1, "Thread-2");
		
		t1.start();
		Thread.sleep(10);
		t2.start();

	}

}
