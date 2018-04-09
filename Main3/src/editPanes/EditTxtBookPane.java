package editPanes;

import java.io.File;

import holders.TextBook;
import instances.BagInstance;
import instances.PaneInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import main.TestLogin;

public class EditTxtBookPane {
	final static int width = 725, height = 700;
	
	Image img;
	private FileChooser fc = new FileChooser();
	
	Alert inAlert = new Alert(AlertType.ERROR);
	private final ImageView txtBkImage = new ImageView();
	
	
	private final Button btnEdit = new Button("Edit TextBook"), btnSearchImg = new Button("Browse"), btnRemove = new Button("Remove TextBook");
	
	private final Label lblTitle = new Label("Title:"), lblAuthor = new Label("Author"),
			lblBIsbn = new Label("ISBN:"), lblImgDirect = new Label("TextBook Image: Click browse to search for Image in Computer"),
			lblBlank = new Label("\n"), lblBl = new Label("\n"), lblPrice = new Label("Price:");
	
	private final TextField txtTitle = new TextField(), txtAuthor = new TextField(), txtBIsbn = new TextField(),
			txtImg = new TextField(), txtPrice = new TextField(); //might take out txtImg
	
	private final VBox vContainer = new VBox(), vImage = new VBox();
	private final HBox hEdit = new HBox();
	
	public EditTxtBookPane() {
		hEdit.setSpacing(55);
		vContainer.setSpacing(10);
		vImage.setSpacing(10);
		
		vContainer.getChildren().addAll(lblBl, lblTitle, txtTitle, lblAuthor, txtAuthor, lblBIsbn, txtBIsbn, lblPrice, txtPrice, btnEdit, btnRemove);
		vImage.getChildren().addAll(lblBlank, lblImgDirect, txtImg, txtBkImage, btnSearchImg);
		hEdit.getChildren().addAll(vImage, vContainer);
	}
	
	public void setButtons() {
		btnEdit.setOnAction(e-> {
			if (txtBIsbn.getText().isEmpty() || txtTitle.getText().isEmpty() || txtAuthor.getText().isEmpty() || txtImg.getText().isEmpty()) {
				PaneInstance.tbap.setAlert(); //might not work 
				inAlert.show();
			}else {
				TextBook t = new TextBook(Double.parseDouble(txtPrice.getText()), txtTitle.getText(), txtBIsbn.getText(),
			       		txtAuthor.getText(), txtImg.getText());
				BagInstance.tbb.editTextBookArray(BagInstance.tbb.getPlace(), t);
			}
		});
		btnSearchImg.setOnAction(e-> {
			File image = fc.showOpenDialog(TestLogin.mainStage);
			img = new Image("file:"+image.getAbsolutePath());
			txtImg.setText(image.getAbsolutePath());

			
			txtBkImage.setFitHeight(350);
			txtBkImage.setFitWidth(250);
			txtBkImage.setImage(img);
		});
	}
	
	public HBox gethTBEdit(TextBook textBook) {
		TestLogin.setWidth(width, height);
		img = new Image("file:" +textBook.getImgCover());
		txtBkImage.setFitHeight(350);
		txtBkImage.setFitWidth(250);
		txtBkImage.setImage(img);
		txtBIsbn.setText(textBook.getIsbn());
		txtTitle.setText(textBook.getTitle());
		txtAuthor.setText(textBook.getAuthor());
		txtPrice.setText(String.valueOf(textBook.getDblPrice()));
		txtImg.setText("");//might take out
		return hEdit;
	}
}
