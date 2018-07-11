package thread;

public class ThreadA {

	public static void main(String[] args){
		ThreadB b = new ThreadB();
//		b.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized(b){
			try{
				b.start();
				System.out.println("Waiting for b to complete...");
				if(b.isAlive())
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				b.wait();
			}catch(Exception e){
				e.printStackTrace();
			}

			System.out.println("Total is: " + b.total);
		}

		/*try {
			b.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}

class ThreadB extends Thread{
	int total;
	@Override
	public void run(){
		synchronized(this){
			System.out.println("b run");
			for(int i=0; i<10 ; i++){
				total += i;
				try {
					System.out.println("i="+i);
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("notifying");
			notify();
		}
	}
}
