package LinkedList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_InsertInt {
	
	private static LinkedList processListSorted(LinkedList list, Integer data) {
		Collections.sort(list, Comparator.reverseOrder());
		List subList = new ArrayList(list.subList(list.indexOf(data)+1, list.size()));
		list.removeAll(subList);
		
		list.add(0,list.peekLast());
		list.removeLast();
		return list;
	}
	
	private static LinkedList processListUnSorted(LinkedList list, Integer data) {
		List subList = new ArrayList(list.subList(list.indexOf(data)+1, list.size()));
		list.removeAll(subList);
		
		list.add(0,list.peekLast());
		list.removeLast();
		return list;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,11,14,12,5,6,7,8,9,10));
		LinkedList_InsertInt.processListSorted(new LinkedList<>(list), 5).forEach(a -> System.out.print(a+" "));
		System.out.println("\n");
		LinkedList_InsertInt.processListUnSorted(new LinkedList<>(list), 5).forEach(a -> System.out.print(a+" "));
		
	}

}
