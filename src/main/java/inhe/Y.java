package inhe;

public class Y implements X{

	public Y() {
		System.out.println("Y cons");
		show();
	}

	public void show(){
		System.out.println("Y show");
	}
	
	public static void main(String[] args) {
		X x = new Y();
		x.X();
	}

	@Override
	public void X() {
		System.out.println("a");
	}

}
