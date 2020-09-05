package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String fName, String lName, int nPage,
					String pub, int pubYear, String til, String courseN) {
		super(fName, lName, nPage, pub, pubYear, til);
		courseName = courseN;
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
		return String.format("%s%s %d",super.toString(), courseName + assignedChapters);
	}
}
