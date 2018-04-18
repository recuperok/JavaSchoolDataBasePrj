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
	private int tElements, sElements;
	private String fileName = "Resource/Person.dat";
	
	public int getNElements(int choice) {
		int nElements = 0;
		if (choice == 1) {
			nElements = sElements; //student
		}else if(choice == 2) {
			nElements = tElements;
		}
		return nElements;
	}
	
	public BodyBag(int maxSize) {               //Check this for two different Person arrays -student -teacher
		this.teacherArray = new Person[maxSize];		
		this.studentArray = new Person[maxSize];
	}
	
	public void insertArray(Person personAdd, int choice) {
		if (choice == 1) {
			studentArray[sElements++] = personAdd;
		}else if (choice == 2) {
			//System.out.println(tElements);
			teacherArray[tElements++] = personAdd;	
		}
	}
	public Person[] getPersonArray(int choice) {
		Person[] p = studentArray;
		if (choice == 1) {
			p = studentArray;
		}else if (choice == 2) {
			p = teacherArray;
		}
		return p;
	}
	
	public void writeBinary(int choice) {
		int nElements = 0;
		if (choice == 1) {
			nElements = sElements; //student
			fileName = "Resource/Student.dat";
		}else if(choice == 2) {
			nElements = tElements;
			fileName = "Resource/Teacher.dat";
		}
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
	
	public void readBinary(int choice) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		@SuppressWarnings("unused")
		int nElements;
		if (choice == 1) {
			nElements = sElements; //student
			fileName = "Resource/Student.dat";
		}else if(choice == 2) {
			nElements = tElements;
			fileName = "Resource/Teacher.dat";
		}
		
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
