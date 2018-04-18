package panes;

import instances.BagInstance;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NamePane {
	String id = "00000";
	public final VBox vPersonInfo = new VBox();
	
	private Label lblFirstName = new Label("First Name:"), lblLastName = new Label("Last Name:"), 
			lblAddress = new Label("Address"), lblPhone = new Label("Phone Number:"), lblBl = new Label("\n"),
			lblId = new Label("ID Number");
	public Label  lblIdNumber = new Label("");
	
	public final TextField txtFirstName = new TextField(), txtLastName = new TextField(), txtAddress = new TextField(), 
			txtPhone = new TextField(), txtId = new TextField();
	
	public void setNamePane() {

		vPersonInfo.getChildren().addAll(lblBl, lblFirstName, txtFirstName, lblLastName, txtLastName, lblId, lblIdNumber,
				lblAddress, txtAddress, lblPhone, txtPhone);
	}
	
	public void setTxtId() {
		lblIdNumber.applyCss();
		lblIdNumber.layout();
		lblIdNumber.setText(String.valueOf(getId()));
		//txtId.setPromptText((String.valueOf(getId())));
	}
	
	public NamePane() {
		setNamePane();
	}
	public String getId() {
		//have to do choice in this for teacher or student
		int idHolder = 0;
		for (int x = 0; x <= BagInstance.bb.getNElements(2); x++) {
			if (BagInstance.bb.getNElements(2) != 0) {
				//System.out.println(BagInstance.bb.getPersonArray(2)[x].getId());
				if (BagInstance.bb.getPersonArray(2)[x] == null) { //this will make sure noone gets the same ID;
				}else {
					idHolder = Integer.parseInt(id);
					idHolder++;
					id = Integer.toString(idHolder);
					for (int y = 0; y < 5; y++) {
						if (id.length() < 5) {
							id = "0" + id;
						}else {
							break;
						}
					}
					break;
				}
			}
		}		
		return id;
	}
	
	public void clearName() {
		txtAddress.clear();
		txtFirstName.clear();
		txtLastName.clear();
		txtPhone.clear();
		txtId.clear();
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
