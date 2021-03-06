package addPane;

import java.io.File;
import holders.TextBook;
import instances.BagInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import main.Login;

public class TxtBookAddPane {
	final static int width = 725, height = 700;

	Alert inAlert = new Alert(AlertType.ERROR);
	
	Image img;	
	private FileChooser fc = new FileChooser();
	Image imgCover = new Image("file:JWU-logo-1.jpg");
	private final ImageView txtBkImage = new ImageView(imgCover);
	
	// These are the buttons for the user inputs
	private final Button btnTBAdd = new Button("Add TextBook"), btnSearchImg = new Button("Browse");
	
	// This is where the labels are declared and given titles
	private final Label lblTitle = new Label("Title:"), lblAuthor = new Label("Author"),
			lblBIsbn = new Label("ISBN:"), lblImgDirect = new Label("TextBook Image: Click browse to search for Image in Computer"),
			lblBlank = new Label("\n"), lblBl = new Label("\n"), lblPrice = new Label("Price:");
	
	// This is where the textFields are declared
	private final TextField txtTitle = new TextField(), txtAuthor = new TextField(), txtBIsbn = new TextField(),
			txtImg = new TextField(), txtPrice = new TextField(); //might take out txtImg
	
	// These boxes are what contain all the items
	private final VBox vContainer = new VBox(), vImage = new VBox();
	private final HBox hTBAdd = new HBox();
	
	// this constructor is setting the items to the boxes for the GUI
	public TxtBookAddPane() {
		setButtons();
		hTBAdd.setSpacing(55);
		vContainer.setSpacing(10);
		vImage.setSpacing(10);
		vContainer.getChildren().addAll(lblBl, lblTitle, txtTitle, lblAuthor, txtAuthor, lblBIsbn, txtBIsbn, lblPrice, txtPrice, btnTBAdd);
		vImage.getChildren().addAll(lblBlank, lblImgDirect, txtImg, txtBkImage, btnSearchImg);
		hTBAdd.getChildren().addAll(vImage, vContainer);
	}
	
	// This is setting an alert for invalid inputs
	public void setAlert() {
		if (txtBIsbn.getText().replace(" ", "").equals("") || txtTitle.getText().replace(" ", "").equals("") || 
				txtAuthor.getText().replace(" ", "").equals("") || txtImg.getText().replace(" ", "").equals("")) {
			inAlert.setTitle("Warning");
			inAlert.setHeaderText("Invalid Input: 0x0001");
			inAlert.setContentText("It seems you forgot to put in all the info");
		}
	}
	
	public void setButtons() {
		btnTBAdd.setOnAction(e-> { // this button adds the textbook
			// Firts if is determining if all the textboxes are filled
			if (txtBIsbn.getText().replace(" ", "").equals("") || txtTitle.getText().replace(" ", "").equals("") || 
					txtAuthor.getText().replace(" ", "").equals("") || txtImg.getText().replace(" ", "").equals(""))  {
				setAlert();
				inAlert.show(); // this will show the warning that not all fields are filled
			}else {
				for (int x = 0 ; x <= BagInstance.tbb.getNElements(); x++) {
					if (x == BagInstance.tbb.getNElements() || BagInstance.tbb.getCourseArray()[0].getIsbn().equals(txtBIsbn.getText())) {
						TextBook t = new TextBook(Double.parseDouble(txtPrice.getText()), txtTitle.getText(), txtBIsbn.getText(),
					       		txtAuthor.getText(), txtImg.getText());
						BagInstance.tbb.insertTextBookArray(t);
						txtBIsbn.clear();
						txtTitle.clear();
						txtAuthor.clear();
						txtImg.clear();
						break;
					}
				}
				
			}
		});
		
		btnSearchImg.setOnAction(e-> { // This button searches for the textbook cover
			File image = fc.showOpenDialog(Login.mainStage);
			img = new Image("file:"+image.getAbsolutePath());
			txtImg.setText(image.getAbsolutePath());

			
			txtBkImage.setFitHeight(350);
			txtBkImage.setFitWidth(250);
			txtBkImage.setImage(img);
		});
	}
	
	public HBox gethTBAdd() {
		Login.setWidth(width, height);
		txtBIsbn.clear();
		txtTitle.clear();
		txtAuthor.clear();
		txtImg.clear();//might take out
		txtBkImage.setImage(null);
		return hTBAdd;
	}
}