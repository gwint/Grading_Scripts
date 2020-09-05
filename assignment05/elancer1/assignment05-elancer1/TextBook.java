package assignment05;

import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private ArrayList<Integer> assignedChapters = new ArrayList<Integer>();
	
	
	public TextBook(String fName, String lName, int num, String pub, int year, String bTitle, String cName) {
		super(fName, lName, num, pub, year, bTitle);
		courseName = cName;
	}

	public String getCourseName() {
		return courseName;
	}


	public ArrayList<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
	
}
