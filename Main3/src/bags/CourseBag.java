package bags;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import holders.Courses;

public class CourseBag {
	private String fileName = "Resources/Course.dat";
	int nElements;
	int place = 0;
	private Courses[] courseArray;
	
	public CourseBag(int maxSize) {
		this.courseArray = new Courses[maxSize];
	}
	
	public void insertCourseArray(Courses courseAdd) {
		System.out.println(nElements);
		courseArray[nElements++] = courseAdd;
	}
	
	public int getNElements() {
		return nElements;
	}
	
	public Courses[] getCourseArray() {
		return courseArray;
	}
	
	public Courses searchCourseNum(String cNum) {
		if (cNum.length() == 4) {
			for (int x = 0; x < nElements;) {
				if (courseArray[x].getcNumber().toString().equals(cNum)) {
					place = x;
					return courseArray[x];
				}else {
					x = x + 1;
				}
			}
		}
		return null;
	}
	
	public void removeCourseArray(String cNum) {
		if (cNum.length() ==  4) {
			for (int x = 0; x < nElements;) {
				if (courseArray[x].getcNumber().toString().equals(cNum)) {
					courseArray[x] = courseArray[x+1];
					for (int y = x + 1; x < nElements;) {
						if (courseArray[y].getcNumber().isEmpty()){
							courseArray[y] = courseArray[y - 1];
						}
					}
				}
			}
		}
	}
	
	public void writeBinary() {
		System.out.println(courseArray[0]);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream dos = new ObjectOutputStream(fos);
			dos.writeObject(courseArray);
			dos.writeInt(nElements);
			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found exception has occured");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception");
			System.out.println(e.getMessage());
		}
		System.out.println("Done writing to the Binary course file.");
	}
	
	public void readBinary() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			courseArray = (Courses[]) ois.readObject();
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
