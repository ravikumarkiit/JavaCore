import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class StackQueue {

	StackQueue(){
	}

	public static void main(String args[]){
		Stack st = new Stack<String>();
		st.push("a");
		st.push("b");
		
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.pop());
//		System.out.println(st.pop()); //Exception in thread "main" java.util.EmptyStackException
		
		LinkedBlockingQueue<String> qu = new LinkedBlockingQueue<String>();
		qu.add("a");
		qu.offer("b");
		
		
		System.out.println(qu.peek());
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.poll());
		System.out.println(qu.peek());
		
		
		
	}
}
