package people;

public class Visitor extends Person implements Comparable<Visitor> {
	
	private final ArrivalTime time;
	
	public Visitor(String name, int age, String id, boolean willAttend, ArrivalTime time) {
		super(name, age, id, willAttend);
		this.time = time;
	}
	
	public Visitor(Visitor other) {
		super(other.name, other.age, other.id, other.willAttend);
		this.time = other.time;
	}
	
	public static int compareByName(Visitor v1, Visitor v2) {
		if (!v1.getLastName().equals(v2.getLastName())) {
			return v1.getLastName().compareTo(v2.getLastName());
		}else {
			return v1.getFirstName().compareTo(v2.getFirstName());
		}
	}
	
	public int compareTo(Visitor other) {
		if(!time.equals(other.time)) {
			return time.compareTo(other.time);
		}else if (!getLastName().equals(other.getLastName())) {
			return getLastName().compareTo(other.getLastName());
		}else if (!getFirstName().equals(other.getFirstName())) {
			return getFirstName().compareTo(other.getFirstName());
		}
		return getAge()-other.getAge();
	}
	public boolean equals(Object object) {
		if(object instanceof Visitor) {
			Visitor other = (Visitor) object;
			return name.equals(other.name) &&
				age == other.age		&&
				id.equals(other.id) 	&&
				willAttend == other.willAttend &&
				time.equals(other.time);
	}
	return false;
	}
	
	public String toFile() {
		String attend = (willAttend)? "YES" : "NO";
		return  name 	+ ", "
			  + age 	+ ", "
			  + id 		+ ", "
			  + attend  + ", "
			  + time;
	}
	
	public String toString() {
		String attend = (willAttend)? "YES" : "NO";
			
		return 	"Name: " + "\t" + "\t"	+ name 	+ "\n" 
			+	"Age: "  + "\t"	+ "\t"  + age 	+ "\n"
			+	"ID: " + "\t" + "\t" 	+ id 	+ "\n"
			+   "Gala:" + "\t" + "\t" + attend + "\n"
			+   "Time:" + "\t" + "\t" + time + "\n";
	}
}
