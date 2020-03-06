package people;

//public abstract class Person {
	public class Person {
	
	protected String name;
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String id;
	protected boolean willAttend;
	
	public Person (String name, int age, String id, boolean willAttend) {
		this.age = age;
		this.name = name;
		this.id = id;
		this.willAttend = willAttend;
	}
	
	public Person (Person other) {
		this.age = other.age;
		this.name = other.name;
		this.id = other.id;
		this.willAttend = other.willAttend;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		String info[] = this.name.split(" ");
		firstName = info[0];
		return firstName;
	}

	public String getLastName() {
		String info[] = this.name.split(" ");
		lastName = info[1];
		return lastName;
	}

	public boolean getWillAttend() {
		if(!willAttend) {
			return false;
		}
		return true;
	}
	public static int compareName(Person p1, Person p2) {
		if (!p1.getLastName().equals(p2.getLastName())) {
			return p1.getLastName().compareTo(p2.getLastName());
		}else if(!p1.getFirstName().equals(p2.getFirstName())) {
			return p1.getFirstName().compareTo(p2.getFirstName());
		}else {
			return p1.getAge() - p2.getAge();
		}
	}
	
	public boolean equals(Object object) {
		if(object instanceof Person) {
			Person other = (Person) object;
			return name.equals(other.name) &&
				age == other.age		&&
				id.equals(other.id) 	&&
				willAttend == other.willAttend;
	}
	return false;
	
	}
	public String toFile() {
		String attend = (willAttend)? "YES" : "NO";
		return  name 	+ ", "
			  + age 	+ ", "
			  + id 		+ ", "
			  + attend;
	}
	
	public String toString() {
		String attend = (willAttend)? "YES" : "NO";
			
		return 	"Name: " + "\t" + "\t"	+ name 	+ "\n" 
			+	"Age: "  + "\t"	+ "\t"  + age 	+ "\n"
			+	"ID: " + "\t" + "\t" 	+ id 	+ "\n"
			+   "Gala:" + "\t" + "\t" + attend + "\n";
	}
	
}
