package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters;
	public TextBook(String FN, String LN, int numP, String pub, int pubYr, String nTitle, String crName) {
		super(FN, LN, numP, pub, pubYr, nTitle);
		courseName = crName;
		assignedChapters = new ArrayList<>();
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
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
