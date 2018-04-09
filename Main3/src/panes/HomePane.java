package panes;

import instances.PaneInstance;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.TestLogin;

public class HomePane {
	
	public final VBox vHomePane = new VBox();
	private final Label lblSchoolName = new Label("Johnson & Wales" + "\n" + "     University");
	private final ImageView selectedImage = new ImageView();
	Image imgLogo = new Image("file:Resources/JWU-logo-1.jpg");
    Font fontJWU = new Font("sansserif", 55);
	
	public HomePane() {
		selectedImage.setImage(imgLogo);
		lblSchoolName.setFont(fontJWU);
		vHomePane.getChildren().addAll(lblSchoolName, selectedImage);		
	}
	
	public VBox getVHomePane() {
		TestLogin.setWidth(600, 700);
		PaneInstance.bp.setLeft(PaneInstance.ep.getVLeft());
		return vHomePane;
	}
}
