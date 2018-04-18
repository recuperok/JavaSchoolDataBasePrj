package bags;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import holders.TextBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TBookBag {
	private String fileName = "Resource/TextBook.dat";
	int nElements;
	private TextBook[] textBookArray;
	int place = 0;
	
	public int getNElements() {
		return nElements;
	}
	
	public TextBook[] getCourseArray() {
		return textBookArray;
	}
	
	public ObservableList<String> getTitle() {
		ObservableList<String> allTitles = FXCollections.observableArrayList();
		try {
			for (int x = 0; x < nElements; x++){
				allTitles.add(textBookArray[x].getTitle());
			}
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return allTitles;
	}
	
	public TBookBag(int maxSize) {
		this.textBookArray = new TextBook[maxSize];
	}
	
	public void insertTextBookArray(TextBook textBookAdd) {
		textBookArray[nElements++] = textBookAdd;
	}
	
	public void editTextBookArray(int x, TextBook textBookEdit) {
		textBookArray[x] = textBookEdit;
	}
	
	public TextBook searchTextBookISBN(String tbIsbn) {
		if (tbIsbn.length() == 10 || tbIsbn.length() == 13) {
			for (int x = 0; x < nElements;) {
				if (textBookArray[x].getIsbn().toString().equals(tbIsbn)){
					place = x;
					return textBookArray[x];
				}else{
					x = x + 1;
				}
			}
		}
		return null;
	}
	
	public int getPlace() {
		return place;
	}
	
	public void writeBinary() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream dos = new ObjectOutputStream(fos);
			dos.writeObject(textBookArray);
			dos.writeInt(nElements);
			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found exception has occured");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception");
			System.out.println(e.getMessage());
		}
		System.out.println("Done writing to the textBook course file.");
	}
	
	public void readBinary() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			textBookArray = (TextBook[]) ois.readObject();
			nElements = ois.readInt();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
 