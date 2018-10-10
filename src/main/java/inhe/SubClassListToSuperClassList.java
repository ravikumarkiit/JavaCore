package inhe;

import java.util.ArrayList;
import java.util.List;

public class SubClassListToSuperClassList {

	static List<X> xlist = new ArrayList<>();
	
	public static void main(String[] args) {
		SubClassListToSuperClassList main = new SubClassListToSuperClassList();
		List<Y> yList = new ArrayList<>();
		yList.add(new Y("1"));
		yList.add(new Y("2"));
		
		main.addToList(yList);
		System.out.println("ListCount = "+ xlist.size());
	}

	private void addToList(List<? extends X> list) {
		xlist.addAll(list);
	}
}
