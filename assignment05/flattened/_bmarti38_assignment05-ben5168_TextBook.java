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
	
	public TextBook (String authorFrstName, String authorLstName, int nmPages, String pub, int pubYear, String ttle, String courseNme) {
		this.authorFirstName = authorFrstName;
		this.authorLastName = authorLstName;
		this.numPages = nmPages;
		this.publisher = pub;
		this.publicationYear = pubYear;
		this.title = ttle;
		this.courseName = courseNme;
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
