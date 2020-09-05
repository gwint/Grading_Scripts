package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	public TextBook(String firstName, String lastName, int numPages, String publisher, int publicationYear,
			String title, String courseName) {
		super(firstName, lastName, numPages, publisher, publicationYear, title);
		this.courseName = courseName;
		
	}
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
	public String getCourseName() {
		return courseName;
	}
	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
}
