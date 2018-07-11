import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;

class User implements Externalizable { 
	int code;
	String name;
	String password;
	Date birthday;
	int socialSecurityNumber;

	public User() {

	}

	@Override
	public String toString() {
		return "User [code=" + code + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", socialSecurityNumber=" + socialSecurityNumber + "]";
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setSocialSecurityNumber(int socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(code);
		out.writeObject(name); 
		// write empty password:
		out.writeObject("");
		out.writeObject(birthday); 
		System.out.println("In WE");
	}

	@Override
	public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
		this.code = in.readInt();
		this.name = (String) in.readObject();
		this.password = (String) in.readObject();
		this.birthday = (Date) in.readObject();
		System.out.println("In RE");
	}
}

public class ExternalizationDemo {

	private String filePath = "user.ser";

	public void serialize() throws IOException {
		User user = new User();

		user.setCode(123);
		user.setName("Tom");
		user.setBirthday(new Date());
		user.setPassword("secret123");
		user.setSocialSecurityNumber(1234567890);

		// serialize object's state
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream outputStream = new ObjectOutputStream(fos);
		outputStream.writeObject(user);
		outputStream.close();


		System.out.println("User's details before serialization:\n" + user);
		System.out.println("Serialization done");
	}

	public void deserialize() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream inputStream = new ObjectInputStream(fis);
		User user = (User) inputStream.readObject();
		inputStream.close();

		System.out.println("User's details afeter de-serialization:\n" + user);
	}

	public static void main(String[] args)
			throws ClassNotFoundException, IOException {
		ExternalizationDemo demo = new ExternalizationDemo();

		demo.serialize();

		System.out.println("\n=============\n");

		demo.deserialize();

	}

}