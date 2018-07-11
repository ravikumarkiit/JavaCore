import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsExample {

	public static void main(String[] args) {
		
		int[] arr = {1,4,2,6,3,8}; // Can use primitives
		System.out.println("Array " +arr+ " "+arr.length);
		
		/**#########################*/
		Set<Integer>  set = new HashSet<>(); // No primitives allowed, No Order, No Duplicates
		set.add(1);
		set.add(5);
		set.add(1);
		set.add(null);
		System.out.println("Set "+set+ " "+set.size());
		
		/**#########################*/
		List<String> lst = new ArrayList<>(); // No primitives allowed, Ordered, Allows Duplicates
		
		lst.add("c");
		lst.add("d");
		lst.add(2,"b");
		lst.add(2,"a");// add will not replace set will; 
//		lst.set(2, "m");
		
		/*lst.add(0,"c");
		lst.add(1,"d");
		lst.add(2,"b");
		lst.add(3,"a");*/
		
		System.out.println("List "+ lst+ " "+ lst.size());
		List<String> lst2 = new ArrayList<>(lst);
		Collections.sort(lst2, Comparator.naturalOrder());
		System.out.println(lst.equals(lst2));//ordering of the elements is taken into consideration.
		
		/**#########################*/
		testFailFast();
	}
	
	public static void testFailFast() {
		List<String> lst = new ArrayList<>();
		
		lst.add("c");
		lst.add("d");
		lst.add(2,"b");
		lst.add(2,"a");
		
		Iterator it = lst.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()); //next() will retrieve and move the pointer to next element
			it.remove(); // Will remove the element retrieved from next()
		}
		System.out.println(lst.size()); // List got modified during iteration by own iterator so NO ConcurrentModificationException, exception if by other iterator 
	}

}
