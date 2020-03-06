package people;

import java.text.DecimalFormat;

public class Employee extends Person implements Comparable<Employee>{
	
	private final String  office;
	private final double  salary;
	private final int 	  years;

	public Employee(Builder builder) {
        super(builder.name, builder.age, builder.id, builder.willAttend);
		this.office 	= builder.office;
		this.salary 	= builder.salary;
		this.years		= builder.years;
	}
	
	public Employee(Employee other) {
        super(other.name, other.age, other.id, other.willAttend);
		this.office 	= other.office;
		this.salary 	= other.salary;
		this.years		= other.years;
	}
	public static int compareSalary(Employee e1, Employee e2) {
		return Double.compare(e1.getSalary(), e2.getSalary());
	}
	
	public int compareTo(Employee other) {
		if (!getLastName().equals(other.getLastName())) {
			return getLastName().compareTo(other.getLastName());
		}else if (!getFirstName().equals(other.getFirstName())) {
			return getFirstName().compareTo(other.getFirstName());
		}else if (getYears() != other.getYears()) {
			return getYears() - other.getYears();
		}else if (getSalary() != other.getSalary()) {
			return (int)(getSalary() - other.getSalary());
		}
		return getAge()-other.getAge();
		
	}
	
	public boolean equals(Object object) {
		if(object instanceof Employee) {
			Employee other = (Employee) object;
			return name.equals(other.name) &&
				age == other.age	&&
				id.equals(other.id) &&
				willAttend == other.willAttend &&
				office.equals(other.office) &&
				salary == other.salary &&
				years == other.years;
			
	}
	return false;
	}
	
	public double getSalary() {
		return salary;
	}

	public int getYears() {
		return years;
	}
	public double payments() {
		return salary / 24;
	}
	
	public static int rankSalary(Employee e1, Employee e2) {
		if(compareSalary(e1, e2) != 0) {
			return compareSalary(e1, e2);
		}else if (!e1.getLastName().equals(e2.getLastName())) {
			return e1.getLastName().compareTo(e2.getLastName());
		}else if (!e1.getFirstName().equals(e2.getFirstName())) {
			return e1.getFirstName().compareTo(e2.getFirstName());
		}else if (e1.getAge()- e2.getAge() != 0) {
			return e1.getAge()- e2.getAge();
		}
		return e1.getYears()- e2.getYears();
	}
	
	public static int rankYears(Employee e1, Employee e2) {
		if (e1.getYears()- e2.getYears() != 0){
			return e1.getYears()- e2.getYears();
		}else if (!e1.getLastName().equals(e2.getLastName())) {
			return e1.getLastName().compareTo(e2.getLastName());
		}else if (!e1.getFirstName().equals(e2.getFirstName())) {
			return e1.getFirstName().compareTo(e2.getFirstName());
		}else if(compareSalary(e1, e2) != 0) {
			return compareSalary(e1, e2);
		}
		return e1.getAge()- e2.getAge();
	}
	DecimalFormat decFrmt = new DecimalFormat("0.00");
	public String toFile() {
		String attend = (willAttend)? "YES" : "NO";
		return  name 	+ ", "
			  + age 	+ ", "
			  + id 		+ ", "
			  + attend  + ", "
			  + office  + ", "
			  + decFrmt.format(salary) + ", "
			  + years;
	}

	public String toString() {
		String attend = (willAttend)? "YES" : "NO";
		
		return 	"Name: " + "\t" + "\t"	+ name 	+ "\n" 
			+	"Age: "  + "\t"	+ "\t"  + age 	+ "\n"
			+	"ID: " + "\t" + "\t" 	+ id 	+ "\n"
			+   "Gala:" + "\t" + "\t" + attend + "\n"
			+   "Office:" + "\t" + "\t" + office + "\n"
			+   "Salary:" + "\t" + "\t" + decFrmt.format(salary) + "\n"
			+   "Service:" + "\t" + years + "\n"
			+   "Bi-monthly:" + "\t" + decFrmt.format(payments()) + "\n";
	}
	
	public static class Builder{
		private String name;
		private int age;
		private String	id;
		private boolean willAttend;
		private String office;
		private double salary;
		private int years;
		
		
		public Builder() {
			name 	   	= "Unassigned";
			age 		= 0;
			id 			= "Unassigned";
			office 		= "Unassigned";
			salary 		= 0.0;
			years  		= 0;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setID(String id) {
			this.id = id;
			return this;
		}

		public Builder setWillAttend(boolean willAttend) {
			this.willAttend = willAttend;
			return this;
		}

		public Builder setOffice(String office) {
			this.office	= office;
			return this;
		}
		public Builder setSalary(double salary) {
			this.salary	= salary;
			return this;
		}
		public Builder setYears(int years) {
			this.years = years;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}
}
