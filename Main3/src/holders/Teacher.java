package holders;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Teacher extends Person{
	double salary;
	String rank;
	ArrayList<String> CoursesTeaching = new ArrayList<>();
	
	public Teacher() {}
	
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

	public void setCoursesTeaching(String coursesTeaching) {
		CoursesTeaching.add(coursesTeaching);
	}
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "; ID #:" + id + "; Address:" + address
				+ "; Phone: " + phone + " " + "/nRank" + rank + " making $" + salary + "; Teaching " + CoursesTeaching;
	}
	
	
	
}
