package holders;

import java.util.ArrayList;

public class Teacher {
	double salary;
	String rank;
	ArrayList<String> CoursesTeaching = new ArrayList<>();
	
	public Teacher(double salary, String rank, ArrayList<String> coursesTeaching) {
		super();
		this.salary = salary;
		this.rank = rank;
		CoursesTeaching = coursesTeaching;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public ArrayList<String> getCoursesTeaching() {
		return CoursesTeaching;
	}

	public void setCoursesTeaching(ArrayList<String> coursesTeaching) {
		CoursesTeaching = coursesTeaching;
	}

	@Override
	public String toString() {
		return "The salary is $" + salary + ". They are a(n)" + rank + ", They teach " + CoursesTeaching;
	}
	
	
	
}
