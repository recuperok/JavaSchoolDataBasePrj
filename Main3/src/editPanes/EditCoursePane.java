package editPanes;

import java.util.Optional;

import instances.BagInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditCoursePane {
	Alert courseAlert = new Alert(AlertType.ERROR), alertRemoveC = new Alert(AlertType.CONFIRMATION);
	final static int width = 155, height = 55;																// Variable declarations
	public final Button btnEditCourse = new Button("Edit Course"), btnRemCourse = new Button("Remove Course"), btnTxtAdd = new Button("Add TextBook"), btnTxtRemove = new Button("Remove Textbook");
	
	private final TextField txtCTitle = new TextField(), txtCNum = new TextField(),
			txtCCredit = new TextField();
	
	private ComboBox<String> cmbTxtBooks = new ComboBox<String>();
	
	private final ListView<String> lvTextBooks = new ListView<>();
	
	private final Label lblCTitle = new Label("Course Title:"), lblCNum = new Label("Course Number:"),
			lblCCredit = new Label("Credits"), lblCDesc = new Label("Description:"), 
			lblHeader = new Label("EDIT A COURSE"), lblTextBook = new Label("Textbooks");
	
	private final TextArea txtCDesc = new TextArea();
	
	private final VBox vCourseRem = new VBox(), vCDesc = new VBox();
	private final HBox hCEdit = new HBox(), hTxtBtns = new HBox();
	
	public void setAlerts(int x) {
		if (x == 1) {
			alertRemoveC.setContentText("Are you sure you want to remove?");
			alertRemoveC.setHeaderText("COURSE REMOVAL VERIFICATION");
			alertRemoveC.setTitle("Verification");
			
			Optional<ButtonType> result = alertRemoveC.showAndWait();
			if (result.get() == ButtonType.OK){
				BagInstance.cb.removeCourseArray(txtCNum.getText());
				txtCTitle.clear();
				txtCNum.clear();
				txtCCredit.clear();
				
			} else {
			    
			}
		}else if (x == 2) {
			
		}
		
	}
	
	public EditCoursePane() {																				// This adds all the items to the VBox and HBox and sets the spacing
		//setAddBtn();
		
		txtCDesc.setMaxWidth(255);
		vCourseRem.setSpacing(10);
		vCDesc.setSpacing(10);
		hTxtBtns.setSpacing(10);
		hCEdit.setSpacing(33);
		
		hTxtBtns.getChildren().addAll(btnTxtAdd, btnTxtRemove);
		vCDesc.getChildren().addAll(lblHeader, lblCDesc, txtCDesc, lblTextBook, cmbTxtBooks,
				lvTextBooks, hTxtBtns);
		vCourseRem.getChildren().addAll(lblCTitle, txtCTitle, lblCNum, txtCNum, lblCCredit, 
				txtCCredit, btnEditCourse);
		
		hCEdit.getChildren().addAll(vCDesc, vCourseRem);
	}
	
	public void setCmb() {																			 		// Setting the combo-box values
		for (int x = 0; x < BagInstance.tbb.getNElements(); x++){									 		// A loop to get all the textbooks from the textbook file
			if (cmbTxtBooks.getItems().contains(BagInstance.tbb.getCourseArray()[x].getTitle())){	 		// If the textbook is already in the combo-box it will not add it again
			}else {
				cmbTxtBooks.getItems().add(BagInstance.tbb.getCourseArray()[x].getTitle());			 		// this is the else that adds the textbook to the combo-box since it is not in it already
			}
		}
		lvTextBooks.setMaxHeight(125);																 		// Just setting the height of the list-view
	}	

	public void setAddBtn() {
		btnRemCourse.setOnAction(e->{
			setAlerts(1);
		});
		
		btnTxtRemove.setOnAction(e-> {
			if (!(lvTextBooks.getSelectionModel().isEmpty())) {
				cmbTxtBooks.getItems().add(lvTextBooks.getSelectionModel().getSelectedItem());
				lvTextBooks.getItems().remove(lvTextBooks.getSelectionModel().getSelectedItem());
			}
		});
		
		btnTxtAdd.setOnAction(e-> {
			if (cmbTxtBooks.getValue().equals("")){
				
			}else{
				lvTextBooks.getItems().add(cmbTxtBooks.getValue());      										// This takes the Textbook from the combobox and displays it into a viewer
				cmbTxtBooks.getItems().remove(cmbTxtBooks.getValue()); 										    // This removes the textbook that was just added
				setCmb();
				txtCTitle.clear();
				txtCNum.clear();
				txtCCredit.clear();
			}
				
			 										
		});
	}
	
	public HBox getEditCP() {
		setCmb();
		txtCTitle.clear();
		txtCNum.clear();
		txtCCredit.clear();
		return hCEdit;
	}
}