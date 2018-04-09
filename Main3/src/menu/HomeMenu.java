package menu;

import instances.MenuInstance;
import instances.PaneInstance;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import main.TestLogin;

public class HomeMenu {
	public final Menu menuHome = new Menu("Home");
	public final MenuItem ItemHome = new MenuItem("Home");
	public final MenuItem ItemLogout = new MenuItem("Log Out");
	
	public HomeMenu() {
		menuHome.getItems().addAll(ItemHome, ItemLogout);
		ItemHome.setOnAction(e->{
			PaneInstance.bp.setCenter(null);
			PaneInstance.bp.setCenter(PaneInstance.hp.getVHomePane());
			PaneInstance.bp.setTop(MenuInstance.mb);
		});
		ItemLogout.setOnAction(e->{
			PaneInstance.bp.setCenter(null);
			PaneInstance.bp.setTop(null);
			PaneInstance.bp.setLeft(null);
			PaneInstance.bp.setCenter(PaneInstance.lp.getVLogInfo());
			PaneInstance.lp.setTxtBox();
			TestLogin.setWidth(400, 400);
		});
	}
	
	public Menu getMHome() {
		return menuHome;
	}
}
