package bags;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import holders.Person;

public class BodyBag {
	private Person[] teacherArray;
	private Person[] studentArray;
	private int nElements;
	private String fileName = "Resources/Person.dat";
	
	public int getNElements() {
		return nElements;
	}
	
	public BodyBag(int maxSize) {               //Check this for two different Person arrays -student -teacher
		this.teacherArray = new Person[maxSize];		
		this.studentArray = new Person[maxSize];
	}
	
	public void insertArray(Person personAdd) {
		teacherArray[nElements++] = personAdd;
	}
	
	public void writeBinary() {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream dos = new ObjectOutputStream(fos);
			dos.writeObject(teacherArray);
			dos.writeInt(nElements);
			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception occured");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception");
			System.out.println(e.getMessage());
		}
		System.out.println("Done Writing to the Person binary file.");
	}
	
	public void readBinary() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			teacherArray = (Person[]) ois.readObject();
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
