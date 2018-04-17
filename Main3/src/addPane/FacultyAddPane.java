package addPane;

import instances.BagInstance;
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
		vTeacherAdd.setSpacing(10);
		vListView.setSpacing(10);
		hTeacherAdd.setSpacing(10);
		
		vTeacherAdd.getChildren().addAll(lblBlank, lblSalary, txtSalary, lblRank, cmbRanks, btnAddTeacher);
		vListView.getChildren().addAll(lblBl, lblTeaching, cmbTeaching, lvClasses, btnAddCourse);
		hTeacherAdd.getChildren().addAll(PaneInstance.ep.getNamePane(), vListView, vTeacherAdd);
	}
	
	public void setCmbs() {
		if (cmbRanks.getItems().isEmpty()) {
			cmbRanks.getItems().addAll("Teacher" , "Adminastrator", "Department Chair");
		}
		
		//cmbTeaching.getItems().addAll(null);
		System.out.println(BagInstance.cb.getNElements());
		for (int x = 0; x < BagInstance.cb.getNElements(); x++) {
			
			if (cmbTeaching.getItems().contains(BagInstance.cb.getCourseArray()[x].getcTitle())) {
			}else {
				cmbTeaching.getItems().add(BagInstance.cb.getCourseArray()[x].getcTitle());
			}
		}
	}
	
	public void setBtns() {
		btnAddCourse.setOnAction(e-> {
			if (cmbTeaching.getValue().equals("")) {
			}else {
				lvClasses.getItems().add(cmbTeaching.getValue());
				cmbTeaching.getItems().remove(cmbTeaching.getValue());
				cmbTeaching.setValue("");
			}
		});
		
		btnAddTeacher.setOnAction(e-> {
			if (cmbRanks.getValue() == null || PaneInstance.ep.txtFirstName.getText().isEmpty() || PaneInstance.ep.txtLastName.getText().isEmpty()
					|| PaneInstance.ep.txtAddress.getText().isEmpty()) {
				setAlert();
				textBookAlert.show();
			}else {
				//code for adding teacher to binary goes here
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
		PaneInstance.ep.clearName();
		cmbRanks.setValue("");
		cmbTeaching.setValue("");
		lvClasses.getItems().removeAll(lvClasses.getItems());
		txtSalary.clear();
		return hTeacherAdd;
	}
}