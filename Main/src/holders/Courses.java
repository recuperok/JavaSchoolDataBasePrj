package holders;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Courses implements Serializable {
	String cNumber, cTitle, cDescription;  //cNumber should be 4 numbers
	//Teacher prof = new Teacher();
	double cCredits;
	
	public Courses(String cNumber, String cTitle, String cDescription, double cCredits) {
		super();
		this.cNumber = cNumber;
		this.cTitle =cTitle;
		this.cDescription = cDescription;
		this.cCredits = cCredits;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public double getcCredits() {
		return cCredits;
	}

	public void setcCredits(double cCredits) {
		this.cCredits = cCredits;
	}

	@Override
	public String toString() {
		return "Course Number" + cNumber + ", Course Name" + cTitle + ", Description" + cDescription + ", Credits"
				+ cCredits;
	}	
}