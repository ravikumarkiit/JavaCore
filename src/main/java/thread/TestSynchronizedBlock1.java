package thread;

public class TestSynchronizedBlock1 {

	public static void main(String[] args) {
		Synchronization obj = new TestSynchronizedBlock1.Synchronization();//only one object  
		MyThread1 t1=new TestSynchronizedBlock1.MyThread1(obj);  
		MyThread2 t2=new TestSynchronizedBlock1.MyThread2(obj);  
		t1.start();  
		t2.start();  
	}
	
	
	static class Synchronization {
		
		void printTable(int n){  
			synchronized(this){//synchronized block  
				for(int i=1;i<=5;i++){  
					System.out.println(n*i);  
					try{  
						Thread.sleep(400);  
					}catch(Exception e){System.out.println(e);}  
				}  
			}  
		}//end of the method  
	}  
	
	static class MyThread1 extends Thread{  
		Synchronization t;  
		MyThread1(Synchronization t){  
			this.t=t;  
		}  
		public void run(){  
			t.printTable(5);  
		}  
	
	}  
	static class MyThread2 extends Thread{  
		Synchronization t;  
		MyThread2(Synchronization t){  
			this.t=t;  
		}  
		public void run(){  
			t.printTable(100);  
		}  
	}  

}
