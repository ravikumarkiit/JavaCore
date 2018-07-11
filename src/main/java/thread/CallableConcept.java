package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Java program to illustrate Callable
// to return a random number
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableConcept implements Callable<String>
{

	public String call() throws Exception
	{
		// Create random number generator
		Random generator = new Random();

		Integer randomNumber = generator.nextInt(5);

		// To simulate a heavy computation,
		// we delay the thread for some random time
		//		 		Thread.sleep(1 * 1000);
		System.out.println("In");
		return "randomNumber";
	}

	public static void main(String args[]){
		//Get ExecutorService from Executors utility class, thread pool size is 10
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		//create a list to hold the Future object associated with Callable
		List<Future<String>> list = new ArrayList<Future<String>>();

		//Create MyCallable instance
		Callable<String> callable = new CallableConcept();

		for(int i=0; i< 100; i++){
			//submit Callable tasks to be executed by thread pool
			Future<String> future = executorService.submit(callable);
			//add Future to the list, we can get return value using Future
			list.add(future);
		}

		for(Future<String> fut : list){
			try {
				//print the return value of Future, notice the output delay in console
				// because Future.get() waits for task to get completed
				System.out.println(new Date()+ "::"+fut.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		//shut down the executor service now
		executorService.shutdown();
	}
}
