package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {

	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String aFirstName, String aLastName, int nPages, String pub, int pubYear, String title_name, String cName) {
		super(aFirstName, aLastName, nPages, pub, pubYear, title_name);
		courseName = cName;
	}

	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	public String toString() {
		return(super.toString() + "\n" + getCourseName() + " " + assignedChapters);
	}
}
