package assignment05;
import java.util.List;
import java.util.ArrayList;
public class TextBook extends Book {
	
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	public TextBook(String firstName, String lastName, int pages, String publisher, int year, String title, String course) {
		super(firstName, lastName, pages, publisher, year, title);
		courseName=course;
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return super.toString()+"\n "+courseName+" "+assignedChapters;
	}
	
}
