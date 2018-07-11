package thread;

public class SleepOutput {
	
public static void main(String[] args) throws InterruptedException{
		
		System.out.println(Thread.currentThread().getName() + "Has started");
		
		Thread t1 = new Thread(new MyRunnable(), "Thread-1");
		
		t1.start();
		t1.sleep(10000);
		System.out.println(Thread.currentThread().getName() + "Has ended");
		
	}

}

class MyRunnable implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + "Has Started**");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "Has ended**");
		
	}

}
