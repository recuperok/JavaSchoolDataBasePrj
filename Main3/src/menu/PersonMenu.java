package menu;

import instances.PaneInstance;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class PersonMenu {
	String strAdd = "Add", strSearch = "Search";
    public final Menu menuPerson = new Menu("People");
	public final Menu inItemStudent = new Menu("Student");
	public final Menu inItemTeacher = new Menu("Teacher");
	
	//menu items for student
	public final MenuItem itemStudAdd = new MenuItem(strAdd);
	public final MenuItem itemStudSearch = new MenuItem(strSearch);
	
	//menu items for teacher
	public final MenuItem itemTeachAdd = new MenuItem(strAdd);
	public final MenuItem itemTeachSearch = new MenuItem(strSearch);
	
	public PersonMenu() {
		inItemStudent.getItems().addAll(itemStudAdd, itemStudSearch);
		inItemTeacher.getItems().addAll(itemTeachAdd, itemTeachSearch);
		
		menuPerson.getItems().addAll(inItemStudent, inItemTeacher);
		
		itemStudAdd.setOnAction(e->{
			PaneInstance.bp.setCenter(PaneInstance.sap.getHstudadd());
		});
		itemStudSearch.setOnAction(e->{
			
		});
		itemTeachAdd.setOnAction(e->{
			PaneInstance.bp.setCenter(PaneInstance.fap.getAddTeacher());
			PaneInstance.bp.setRight(PaneInstance.np.getVRight());
			PaneInstance.fap.setCmbs();
		});
		itemTeachSearch.setOnAction(e->{
			
		});
		
	}
	
	public void addStudent() {
	}
	
	public Menu getMPerson() {
		return menuPerson;
	}
}
