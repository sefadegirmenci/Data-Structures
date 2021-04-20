
public class Advisor {

	String name;
	String department;

	public Advisor(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Advisor [name=" + name + ", department=" + department + "]";
	}

}
