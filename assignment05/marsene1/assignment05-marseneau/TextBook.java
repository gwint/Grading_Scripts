package assignment05;
import java.util.*;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	
	
	//Constructor adding new parameters
	public TextBook(String first, String last, int pages, String pub, int yr, String bookTitle, String courseName,
			List<Integer> assignedChapters) {
		super(first, last, pages, pub, yr, bookTitle);
		this.courseName = courseName;
		this.assignedChapters = assignedChapters;
	}

	//Get methods for new parameters
	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}

	//Add a new chapter to the assigned chapters
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	


	//@Override
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
