package thread;

public class ThreadLocalExample2 {
	
	public static class MyThread extends Thread {
		
		private /*static volatile*/ ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        public MyThread(String name) {
			super(name);
		}

        @Override
        public void run() {
        	 String name = Thread.currentThread().getName();
        	 if(threadLocal.get() ==null/* && "Thread2".equals(name)*/) {
        		 System.out.println("Thread Local set by "+ name);
        		 threadLocal.set( (int) (Math.random() * 100D) );
        	 }
        	
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
           
            System.out.println(name + " " + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new MyThread("Thread1");
        Thread thread2 = new MyThread("Thread2");

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
        
    }
}
