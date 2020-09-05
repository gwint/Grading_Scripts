package assignment05;

import java.util.ArrayList;
import java.util.List;

public class Textbook extends Book {
	private String courseName;
	List<Integer> assignedChapters = new ArrayList<>();
	
	public Textbook(String authorFirstName, String authorLastName, int numPages, 
			String publisher, int publicationYear, String title,  String course){
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		courseName = course;
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
}
