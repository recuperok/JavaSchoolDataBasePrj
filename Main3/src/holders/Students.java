package holders;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Students implements Serializable {
	ArrayList<String> coursesTook = new ArrayList<String>();
	ArrayList<String> coursesTaking = new ArrayList<String>();
	ArrayList<String> coursesNeeded = new ArrayList<String>();
	double gpa, creditsTaking;
	String major;
	NumberFormat formatter = new DecimalFormat("#0.0");
	
}
