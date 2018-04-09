package instances;

import javafx.scene.control.MenuBar;
import menu.CourseMenu;
import menu.FileMenu;
import menu.HomeMenu;
import menu.PersonMenu;
import menu.TextBookMenu;

public class MenuInstance {
	//public final static MenuBar menuLogin = new MenuBar();
	public final static MenuBar mb = new MenuBar();
	public final static PersonMenu mp = new PersonMenu();
	public final static HomeMenu mh = new HomeMenu();
	public final static CourseMenu cm = new CourseMenu();
	public final static FileMenu fm = new FileMenu();
	public final static TextBookMenu tbm = new TextBookMenu();
	private MenuInstance() {
			
	}
}
