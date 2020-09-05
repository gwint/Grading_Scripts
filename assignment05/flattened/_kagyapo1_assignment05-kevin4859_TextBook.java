package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(){}
	
	public TextBook (String authorFirstName1, String authorLastName1, int numPages1, String publisher1, int publisherYear1, String title1, String courseName1) {
		
		this.authorFirstName = authorFirstName1;
		this.authorLastName = authorLastName1;
		this.numPages = numPages1;
		this.publisher = publisher1;
		this.publicationYear = publisherYear1;
		this.title = title1;
		this.courseName = courseName1;
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
	
	@Override
	public String toString() {
		
		return(super.toString() + "\n" + this.courseName + " " + assignedChapters);
		
	}
}