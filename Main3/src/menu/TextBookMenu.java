package menu;

import instances.PaneInstance;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class TextBookMenu {
	public final Menu menuTextBook = new Menu("Textbooks");
	public final MenuItem itemAdd = new MenuItem("Add Textbook");
	public final MenuItem itemSearch = new MenuItem("Search Textbooks");
	public final MenuItem itemDirectory = new MenuItem("All TextBooks");
	
	public TextBookMenu() {
		setItemActions();
		menuTextBook.getItems().addAll(itemAdd, itemSearch);
	}
	
	public void setItemActions() {
		itemAdd.setOnAction(e-> {
			PaneInstance.bp.setCenter(PaneInstance.tbap.gethTBAdd());
		});
		
		itemSearch.setOnAction(e-> {
			PaneInstance.sp.alertSearchPane(1);
		});
		
		itemDirectory.setOnAction(e-> {
			// ****USE THIS ONCE YOU CREATE AN ADD MAJOR****
		});
	}
	
	public Menu getMenuTxtBook() {
		return menuTextBook;
	}
	
}