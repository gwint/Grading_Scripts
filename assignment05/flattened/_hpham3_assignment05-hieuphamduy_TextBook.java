package assignment05;
import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {

	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String aF, String aL, int noP, String pub, int pubYr, String t, String c) {
		super(aF, aL, noP, pub, pubYr, t);
		setCourseName(c);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}

	public void setAssignedChapters(List<Integer> assignedChapters) {
		this.assignedChapters = assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
	
	
}
