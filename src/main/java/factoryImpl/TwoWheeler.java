package factoryImpl;
public class TwoWheeler implements Vehical {
	
	String name;
	String color;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public TwoWheeler(String name, String color){
		this.name = name;
		this.color= color;
	}
	
}
