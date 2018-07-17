package springTest.reference;

public class Person2 {
	String name;
	int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Person [ name = ");
		sb.append(name);
		sb.append(", age = ");
		sb.append(age);
		sb.append(" ]");
		return sb.toString();
	}
}