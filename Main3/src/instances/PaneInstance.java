package instances;

import addPane.CourseAddPane;
import addPane.FacultyAddPane;
import addPane.StudentAddPane;
import addPane.TxtBookAddPane;
import editPanes.EditCoursePane;
import editPanes.EditTxtBookPane;
import holders.Teacher;
import javafx.scene.layout.BorderPane;
import panes.NamePane;
import panes.HomePane;
import panes.SearchPane;
import panes.loginPane;

public final class PaneInstance {
	public final static NamePane np = new NamePane();
	public final static EditTxtBookPane etbp = new EditTxtBookPane();
	public final static EditCoursePane ecp = new EditCoursePane();
	public final static TxtBookAddPane tbap = new TxtBookAddPane();
	public final static StudentAddPane sap = new StudentAddPane();
	public final static FacultyAddPane fap = new FacultyAddPane();
	public final static CourseAddPane cap = new CourseAddPane();
	public final static BorderPane bp = new BorderPane();
	public final static HomePane hp = new HomePane();
	public final static loginPane lp = new loginPane();
	public final static SearchPane sp = new SearchPane();	
	
	
	private PaneInstance() {
	}
}
