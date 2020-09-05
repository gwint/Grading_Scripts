package assignment05;
import java.util.ArrayList;
import java.util.List; 

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String authorFirstName, String authorLastName, int numPages, String publisher, int publicationYear, String title, String courseName ) {
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		this.courseName = courseName;
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
		super.toString();
		return ("\n"  + courseName + " " + assignedChapters);
	}
	
}
