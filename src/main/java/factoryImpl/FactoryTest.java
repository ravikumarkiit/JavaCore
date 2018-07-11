package factoryImpl;

public class FactoryTest {

	public static void main(String[] args) {
		Vehical vh = VehicalFactory.getVehical("twowheeler");
		System.out.println(vh.getName());
	}

}
