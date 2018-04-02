package addPane;

import instances.PaneInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FacultyAddPane {
	private final static String strAdd = "Add Course";
	
	Alert textBookAlert = new Alert(AlertType.ERROR);
	
	public final Button btnAddCourse = new Button(strAdd), btnAddTeacher = new Button("Add Teacher"), btnEditTeacher = new Button("Edit Teacher");
	
	private ComboBox<String> cmbTeaching = new ComboBox<>(), cmbRanks = new ComboBox<>();
	
	private final TextField txtSalary= new TextField(); 
	
	private final ListView<String> lvClasses = new ListView<>();
	
	private Label lblSalary = new Label ("Salary:"), lblTeaching = new Label("Courses Teaching:"), lblRank = new Label("Rank:"), lblBlank = new Label("\n"), lblBl = new Label("\n");
	
	public final VBox vTeacherAdd = new VBox(), vListView = new VBox();
	public final HBox hTeacherAdd= new HBox();
	
	public FacultyAddPane() {
		setBtns();
		setCmbs();
		vTeacherAdd.setSpacing(10);
		vListView.setSpacing(10);
		hTeacherAdd.setSpacing(10);
		
		vTeacherAdd.getChildren().addAll(lblBlank, lblSalary, txtSalary, lblRank, cmbRanks, btnAddTeacher);
		vListView.getChildren().addAll(lblBl, lblTeaching, cmbTeaching, lvClasses, btnAddCourse);
		hTeacherAdd.getChildren().addAll(PaneInstance.ep.getNamePane(), vListView, vTeacherAdd);
	}
	
	public void setCmbs() {
		cmbRanks.getItems().addAll("Teacher" , "Adminastrator", "Department Chair");
		//cmbTeaching.getItems().addAll(null);
	}
	
	public void setBtns() {
		btnAddCourse.setOnAction(e-> {
			//if (txtSalary.getText().isEmpty() || cmbRanks)
		});
		
		btnAddTeacher.setOnAction(e-> {
			if (cmbRanks.getValue() == null || PaneInstance.ep.txtFirstName.getText().isEmpty() || PaneInstance.ep.txtLastName.getText().isEmpty()
					|| PaneInstance.ep.txtAddress.getText().isEmpty()) {
				setAlert();
				textBookAlert.show();
			}
		});
		
		btnEditTeacher.setOnAction(e-> {
			
		});
	}
	public void setAlert() {
		textBookAlert.setTitle("Warning");
		textBookAlert.setHeaderText("Invalid Input: 0x0001");
		textBookAlert.setContentText("It seems you forgot to put in all the info");
	}
	
	
	public HBox getAddTeacher() {
		return hTeacherAdd;
	}
}