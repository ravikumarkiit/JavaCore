package thread;

public class ThreadLocalExample {
	
	public static class MyRunnable implements Runnable {

        private /*static volatile*/ ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
        	 String name = Thread.currentThread().getName();
//        	 if("Thread1".equals(name)) {
        		 threadLocal.set( (int) (Math.random() * 100D) );
//        	 }
        	
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
           
            System.out.println(name + " " + threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance, "Thread1");
        Thread thread2 = new Thread(sharedRunnableInstance, "Thread2");

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
        
    }
}
