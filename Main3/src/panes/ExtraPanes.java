package panes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ExtraPanes {
	public final VBox vPersonInfo = new VBox();
	
	private Label lblFirstName = new Label("First Name:"), lblLastName = new Label("Last Name:"), 
			lblAddress = new Label("Address"), lblPhone = new Label("Phone Number:"), lblBl = new Label("\n");
	
	public final TextField txtFirstName = new TextField(), txtLastName = new TextField(), txtAddress = new TextField(), 
			txtPhone = new TextField();
	
	public void setNamePane() {
		vPersonInfo.getChildren().addAll(lblBl, lblFirstName, txtFirstName, lblLastName, txtLastName, lblAddress, txtAddress, lblPhone, txtPhone);
	}
	
	public ExtraPanes() {
		setNamePane();
	}
	
	public VBox getNamePane() {
		return vPersonInfo;
	}
	// Can not do A Top because of BarMenu
	private final VBox vLeft = new VBox();
	private final VBox vRight = new VBox();
	
	public VBox getVLeft() {
		vLeft.setMinWidth(70);
		return vLeft;
	}
	
	public VBox getVRight() {
		vRight.setMinWidth(70);
		return vRight;
	}
}
