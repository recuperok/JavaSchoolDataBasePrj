package panes;

import instances.BagInstance;
import instances.MenuInstance;
import instances.PaneInstance;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class loginPane {
	private final Label lblUser = new Label("Username:"), lblPass = new Label("Password:");
	private final PasswordField pwPass = new PasswordField();
	private final TextField txtUser = new TextField();
	public final VBox VLogInfo = new VBox();
	private final Button btnLogin = new Button("Login");
	
	public loginPane() {
		btnSet();
		VLogInfo.getChildren().addAll(lblUser, txtUser, lblPass, pwPass, btnLogin);
		PaneInstance.bp.setCenter(VLogInfo);
	}
	public void setTxtBox() {
		txtUser.setText("");
		pwPass.setText("");
	}
	public void btnSet() {
		btnLogin.setOnAction(e->{
			if (txtUser.getText().toLowerCase().equals("admin") && pwPass.getText().toLowerCase().equals("password")){
				PaneInstance.bp.setCenter(null);
				PaneInstance.bp.setCenter(PaneInstance.hp.getVHomePane());
				PaneInstance.bp.setTop(MenuInstance.mb);
				BagInstance.tbb.readBinary();
				BagInstance.cb.readBinary();
			}
		});
	}
	public VBox getVLogInfo() {
		btnSet();
		return VLogInfo;
	}
}
