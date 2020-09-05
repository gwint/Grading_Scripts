package assignment05;
import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String authorFN, String authorLN, int nPages, String pub, int pubYr, String ttl, String crsName) {
		super(authorFN, authorLN, nPages, pub, pubYr, ttl);
		courseName = crsName;
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
		return super.toString() + "\n" + assignedChapters;
	}
}
