package addPane;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StudentAddPane {
	final static int width = 155, height = 55;
	
	private final static String strAdd = "Add Course";
	
	public final VBox vStudAdd = new VBox(), vListView = new VBox();
	public final HBox hStudAdd= new HBox();
	
	public final Button btnCNeed = new Button(strAdd), btnCTaking = new Button(strAdd),
			btnCTook = new Button(strAdd);
	
	private final TextField txtCredits = new TextField(); //txtMajor = new TextField(),
	
	private ComboBox<String> cmbCNeed = new ComboBox<>(), cmbCTaking = new ComboBox<>(),
			cmbCTook = new ComboBox<>();
			
	
	private Label lblCNeed = new Label ("Courses Needed:"), lblCTaking = new Label("Courses Taking:"), 
			lblCTook = new Label("Course's Taken:"), lblGpa = new Label("GPA:"), 
			lblCreditsTaken = new Label("Credits Taken");
	
	private final ListView<String> lvCNeed = new ListView<>(), lvCTaking = new ListView<>(),
			lvCTook = new ListView<>();
	
	public StudentAddPane() {
		vStudAdd.setSpacing(5);
		
		vStudAdd.getChildren().addAll(lblCreditsTaken, txtCredits, lblGpa);
		vListView.getChildren().addAll(lblCNeed, cmbCNeed, lvCNeed, btnCNeed, 
				lblCTaking, cmbCTaking, lvCTaking, btnCTaking,
				lblCTook, cmbCTook, lvCTook, btnCTook);
		
		lvCNeed.setMaxSize(width, height);
		lvCTaking.setMaxSize(width, height);
		lvCTook.setMaxSize(width, height);
		
		hStudAdd.setSpacing(15);
		hStudAdd.getChildren().addAll(vStudAdd, vListView);
	}
	
	public void setCmbs() {
		
	}
	public void setBtns() {
		btnCNeed.setOnAction(e->{
			
		});
		
		btnCTaking.setOnAction(e->{
			
		});
		
		btnCTook.setOnAction(e->{
			
		});
	}
	
	public HBox getHstudadd() {
		return hStudAdd;
	}
}
