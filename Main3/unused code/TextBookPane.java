package panes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TextBookPane {
	final static int width = 155, height = 55;
	
	Image imgCover = new Image("file:JWU-logo-1.jpg");
	private final ImageView txtBkImage = new ImageView(imgCover);
	
	
	private final Button btnTBAdd = new Button("Add TextBook"), btnSearchImg = new Button("Browse");
	
	private final Label lblTitle = new Label("Title:"), lblAuthor = new Label("Author"),
			lblBIsbn = new Label("ISBN:"), lblImgDirect = new Label("TextBook Image: Click browse to search for Image in Computer");
	
	private final TextField txtTitle = new TextField(), txtAuthor = new TextField(), txtBIsbn = new TextField(),
			txtImg = new TextField(); //might take out txtImg
	
	private final VBox vContainer = new VBox(), vImage = new VBox();
	private final HBox hTBAdd = new HBox();
	
	public TextBookPane() {
		setButtons();
		vContainer.getChildren().addAll(lblTitle, txtTitle, lblAuthor, txtAuthor, lblBIsbn, txtBIsbn);
		vImage.getChildren().addAll(lblImgDirect, txtImg, btnSearchImg);
		hTBAdd.getChildren().addAll(vImage, vContainer);
	}
	
	public void setButtons() {
		
	}
	
	public HBox gethTBAdd() {
		txtBIsbn.setText("");
		txtTitle.setText("");
		txtAuthor.setText("");
		txtImg.setText("");//might take out
		
		return hTBAdd;
	}
}
