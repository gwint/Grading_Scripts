package assignment05;
import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String authorFN, String authorLN, int numPgs, String pub, int pubYr, String tit, String courseNm) {
		super(authorFN, authorLN, numPgs, pub, pubYr, tit);
		courseName = courseNm;
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
		return super.toString() + "/n" + courseName + " " + assignedChapters;
	}
}
