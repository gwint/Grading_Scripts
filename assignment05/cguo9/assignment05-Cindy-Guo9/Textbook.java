package assignment05;
import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String fn, String ln, int pages, String pub, int pubYear, String title, String cn) {
		super(fn, ln, pages, pub, pubYear, title);
		courseName = cn;
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
		return super.toString() + "\n" + getCourseName() + " " + assignedChapters;
	}	
	
	
}