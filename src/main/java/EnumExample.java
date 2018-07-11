import java.util.stream.Stream;

public class EnumExample {
	/**
	 * define set of constants,
	 * enum constants are static and final implicitly, 
	 * cannot extend any class because it internally extends Enum class, 
	 * improves type safety
	 * Only private constructor for internal attributes initialization
	 */
	public enum Months {

		JAN("Jan", "January"),
		FEB("Feb", "February");

		String shortName;
		String name;

		Months(String shortName, String fullName) {
			this.shortName = shortName;
			this.name= fullName;
		}

	}
	
	public static void main(String args[]) {
		System.out.println(Months.valueOf("JAN"));
		
		for(Months m : Months.values()) {
			System.out.println(m);
		}
		
		Stream.of(Months.values()).forEach(System.out::println);
	}

}
