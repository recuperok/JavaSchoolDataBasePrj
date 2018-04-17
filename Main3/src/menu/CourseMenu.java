package menu;

import instances.PaneInstance;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class CourseMenu {
	public final Menu menuCourse = new Menu("Course");
	public final MenuItem itemAdd = new MenuItem("Add");
	public final MenuItem itemSearch = new MenuItem("Search");
	
	
	public CourseMenu() {
		menuCourse.getItems().addAll(itemAdd, itemSearch);
		
		itemAdd.setOnAction(e-> {
			PaneInstance.bp.setCenter(PaneInstance.cap.getHCAdd());
			PaneInstance.bp.setRight(PaneInstance.ep.getVRight());
			PaneInstance.cap.setCmb();
		});
		
		itemSearch.setOnAction(e-> {
			PaneInstance.sp.searchCourses();
		});
	}
	
	public Menu getMCourse() {
		return menuCourse;
	}
}
