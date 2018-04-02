package menu;

import instances.MenuInstance;
import instances.PaneInstance;
import main.Login;

public class BarMenu {
	public BarMenu() {
		MenuInstance.mb.getMenus().addAll(MenuInstance.mh.getMHome(), MenuInstance.mp.getMPerson(), MenuInstance.cm.getMCourse(),
				MenuInstance.tbm.getMenuTxtBook(), MenuInstance.fm.getMFile());
		MenuInstance.mb.prefWidthProperty().bind(Login.mainStage.widthProperty());		
		PaneInstance.bp.setCenter(PaneInstance.lp.getVLogInfo());
	}
	
}
