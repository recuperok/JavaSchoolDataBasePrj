package menu;

import instances.BagInstance;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class FileMenu {
	public final Menu  menuFile = new Menu("File");
	public final MenuItem itemExport = new MenuItem("Export");
	
	public FileMenu() {
		setMenu();
		menuFile.getItems().add(itemExport);
	}
	
	public void setMenu() {
		itemExport.setOnAction(e-> {
			BagInstance.cb.writeBinary();
			BagInstance.tbb.writeBinary();
			//BagInstance.bb.writeBinary();
		});
	}
	
	public Menu getMFile() {
		return menuFile;
	}
}
