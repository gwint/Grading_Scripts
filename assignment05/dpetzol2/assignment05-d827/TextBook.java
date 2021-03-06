package assignment05;

import java.util.*;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String authorFirstName, String authorLastName, int numPages, String publisher,
			int publicationYear, String title, String courseName) {
		super(authorFirstName, authorLastName, numPages, publisher,
				publicationYear, title);
		this.courseName = courseName;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}

	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
	
}
