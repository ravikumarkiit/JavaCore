package inhe;

public class Y implements X {

	public Y(String id) {
//		super(id);
	}
	
	public Y() {
		System.out.println("Y cons");
		show();
	}

	public void show(){
		System.out.println("Y show");
	}
	
	public static void main(String[] args) {
		X x = new Y();
		x.toDo();
	}

	@Override
	public void toDo() {
		System.out.println("toDo");
	}

}
