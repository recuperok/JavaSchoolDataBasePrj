package main;

import instances.PaneInstance;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import menu.BarMenu;

public class TestLogin extends Application {
	
	public static final Stage mainStage = new Stage();
	BarMenu bm = new BarMenu();
	public static Scene loginScene = new Scene(PaneInstance.bp);
	
	public static void main(String[] args) {
		launch(args);
	}
	public static void setWidth(int x, int y) {
		mainStage.setWidth(x);
		mainStage.setHeight(y);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage.setHeight(400);
		mainStage.setWidth(400);
		loginScene.getStylesheets().add("nice.css");
		mainStage.setScene(loginScene);
		mainStage.setResizable(false);
		mainStage.show();
	}
}