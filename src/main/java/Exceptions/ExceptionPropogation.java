package Exceptions;

public class ExceptionPropogation {


	public static void main(String[] args) {
		try {
			ExceptionPropogation.testException();
		} catch(Exception excp) {
			System.out.println("Exception:" +excp.getMessage());
		}
		System.out.println("Return: "+ ExceptionPropogation.testReturn());
	}

	private static void testException() throws Exception{
		try {
			System.out.println("In Try");
			throw new Exception("try");
		} finally {
			System.out.println("In Finally");
			throw new Exception("finally");
		}
	}

	private static int testReturn() {
		try {
			System.out.println("In Try");
			return 1;
		} finally {
			System.out.println("In Finally");
			return 2;
		}
	}

}
