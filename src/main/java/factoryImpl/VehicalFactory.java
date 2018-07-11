package factoryImpl;

public class VehicalFactory {

	public static Vehical getVehical(String name) {
		
		switch(name) {
		case "car":
			return new Car("name1", "color1") {
				
			};
			
		case "twowheeler":
			return new TwoWheeler("name2", "color2") {
				
			};
		default:
			return null;
		}
	}
}
