package panes;

import java.util.Optional;

import holders.TextBook;
import instances.BagInstance;
import instances.PaneInstance;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

public class SearchPane {
	String input = "";
	Alert error = new Alert(AlertType.ERROR);
	Alert alert = new Alert(AlertType.CONFIRMATION);
	TextInputDialog searchInput = new TextInputDialog("");	
	
	public Alert alertSearchPane(int x) {
		searchSetting(x);
		return alert;
	}
	public void searchSetting(int x) {
		if (x == 1) {
			searchTxtBk();
		} else if (x ==  2) {
		
		}
	}
	
	public void searchCourses() {
		Optional<String> result;
		searchInput.getEditor().clear();
		searchInput.setTitle("Course Search");
		searchInput.setContentText("Please enter the Course Numer:");
		result = searchInput.showAndWait();
		
		if (result.isPresent()) {
			if (result.get().length() == 4 || result.get().contains("[0-9]+")) {
				input = result.get();
				System.out.println(BagInstance.cb.searchCourseNum(input));
				PaneInstance.bp.setCenter(PaneInstance.ecp.getEditCP()); // Kevin Create the edit pane for course  
			}
		}
	}
	
	public void searchTxtBk() {
		Optional<String> result;
		searchInput.getEditor().clear();
		searchInput.setTitle("TextBook Lookup");
		searchInput.setContentText("Please enter the ISBN");
		result = searchInput.showAndWait();

		if (result.isPresent()) {
			if ((result.get().length() == 13 || result.get().length() == 10) && result.get().matches("[0-9,X,x]+") == true) {
				input = result.get();
				if (BagInstance.tbb.searchTextBookISBN(input) == null || BagInstance.tbb.searchTextBookISBN(input) == null) {
					error.setTitle("Warning: No Textbook");
					error.setHeaderText("Invalid Input: 0x1001");
					error.setContentText("There is no textbook with this ISBN");
					error.show();
				}else {
					System.out.println("SEARCHING");
					PaneInstance.bp.setCenter(PaneInstance.etbp.gethTBEdit(BagInstance.tbb.searchTextBookISBN(input)));
					
				}
				
				/*TextBook holder = BagInstance.tbb.searchTextBookISBN(input);
				if (!(holder == null)) {
					System.out.println("SEARCHING");
					PaneInstance.bp.setCenter(PaneInstance.etbp.gethTBEdit(BagInstance.tbb.searchTextBookISBN(input)));
				}
				if (holder == null || holder.getIsbn().isEmpty()) {
					error.setTitle("Warning: No Textbook");
					error.setHeaderText("Invalid Input: 0x1001");
					error.setContentText("There is no textbook with this ISBN");
					error.show();
				}*/
			}else {
				error.setTitle("Warning: Incorrect Data Entry");
				error.setHeaderText("Invalid Input: 0x0110");
				error.setContentText("Invalid ISBN: ISBN MUST BE 13 INTEGERS");
				error.show();
			}
		}else {
			searchInput.close();
		}
	}
}
