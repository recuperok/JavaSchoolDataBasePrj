package addPane;

import holders.Courses;
import instances.BagInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CourseAddPane {
	Alert courseAlert = new Alert(AlertType.ERROR);
	final static int width = 155, height = 55;																// Variable declarations
	public final Button btnAddCourse = new Button("Add Course"), btnTxtAdd = new Button("Add TextBook"), btnTxtRemove = new Button("Remove Textbook");
	
	private final TextField txtCTitle = new TextField(), txtCNum = new TextField(),
			txtCCredit = new TextField();
	
	private ComboBox<String> cmbTxtBooks = new ComboBox<String>();
	
	private final ListView<String> lvTextBooks = new ListView<>();
	
	private final Label lblCTitle = new Label("Course Title:"), lblCNum = new Label("Course Number:"),
			lblCCredit = new Label("Credits"), lblCDesc = new Label("Description:"), 
			lblHeader = new Label("ADD A COURSE"), lblTextBook = new Label("Textbooks");
	
	private final TextArea txtCDesc = new TextArea();
	
	private final VBox vCourseAdd = new VBox(), vCDesc = new VBox();
	private final HBox hCAdd = new HBox(), hTxtBtns = new HBox();
	
	public CourseAddPane() {																				// This adds all the items to the VBox and HBox and sets the spacing
		setAddBtn();
		
		txtCDesc.setMaxWidth(255);
		vCourseAdd.setSpacing(10);
		vCDesc.setSpacing(10);
		hTxtBtns.setSpacing(10);
		hCAdd.setSpacing(33);
		
		hTxtBtns.getChildren().addAll(btnTxtAdd, btnTxtRemove);
		vCDesc.getChildren().addAll(lblHeader, lblCDesc, txtCDesc, lblTextBook, cmbTxtBooks,
				lvTextBooks, hTxtBtns);
		vCourseAdd.getChildren().addAll(lblCTitle, txtCTitle, lblCNum, txtCNum, lblCCredit, 
				txtCCredit, btnAddCourse);
		
		hCAdd.getChildren().addAll(vCDesc, vCourseAdd);
	}
	
	public void setAlert() {
		courseAlert.setTitle("Error");
		courseAlert.setHeaderText("Invalid Input: 0x0101");
		courseAlert.setContentText("Inputted values are not correct");
	}
	
	public void setCmb() {																			 		// Setting the combo-box values
		for (int x = 0; x < BagInstance.tbb.getNElements(); x++){									 		// A loop to get all the textbooks from the textbook file
			if (cmbTxtBooks.getItems().contains(BagInstance.tbb.getCourseArray()[x].getTitle())){	 		// If the textbook is already in the combo-box it will not add it again
			}else {
				cmbTxtBooks.getItems().add(BagInstance.tbb.getCourseArray()[x].getTitle());			 		// this is the else that adds the textbook to the combo-box since it is not in it already
			}
		}
		lvTextBooks.setMaxHeight(100);																 		// Just setting the height of the list-view
	}
	

	public void setAddBtn() {
		btnAddCourse.setOnAction(e->{
			if (txtCNum.getText().replace(" ", "").equals("") || txtCTitle.getText().replace(" ", "").equals("") ||
					txtCDesc.getText().replace(" ", "").equals("") || txtCCredit.getText().replace(" ", "").equals("")) {
				
				setAlert();
				courseAlert.show();
			}else {				
				for (int x = 0 ; x <= BagInstance.cb.getNElements(); x++) {
					if (x == BagInstance.cb.getNElements() || BagInstance.cb.getCourseArray()[0].getcTitle().isEmpty() || 
							!(BagInstance.cb.getCourseArray()[x].getcNumber().equals(txtCNum.getText()))) {
						
						Courses c = new Courses(txtCNum.getText(), txtCTitle.getText(), txtCDesc.getText(),
								Double.parseDouble(txtCCredit.getText()));
						BagInstance.cb.insertCourseArray(c);
						lvTextBooks.getItems().removeAll(lvTextBooks.getItems());
						setCmb();
						txtCDesc.clear();
						txtCTitle.clear();
						txtCNum.clear();
						txtCCredit.clear();
						//System.out.println("hello");
						break;
					}else { // if (BagInstance.cb.getCourseArray()[x].getcTitle().equals(txtCTitle))
						// DO NOTHING 
					}
				}
			}			
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
				cmbTxtBooks.setValue("");
			}
				
			 										
		});
	}
	
	public HBox getHCAdd() {																				// this function is returning the HBox that will be placed inside a pane
		lvTextBooks.getItems().removeAll(lvTextBooks.getItems());											//***THESE RESET ALL THE VALUES
		cmbTxtBooks.setValue("");																			//	   |     |    |   |    |
		txtCDesc.clear();																			//     |     |	  |	  |	   |
		txtCTitle.clear();																			//	   |	 |	  |	  |	   |
		txtCNum.clear();																				//	   |     |	  |	  |	   |
		txtCCredit.clear();																				//	   V     V    V   V    V
		return hCAdd;
	}
}